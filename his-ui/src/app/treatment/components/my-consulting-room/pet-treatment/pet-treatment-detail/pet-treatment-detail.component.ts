import {Component, Input, OnChanges, OnDestroy, OnInit, SimpleChanges, ViewChild} from '@angular/core';
import {Router} from "@angular/router";
import {FormArray, FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {Observable} from "rxjs/Observable";
import {ModalComponent} from "ng2-bs3-modal/ng2-bs3-modal";
import {Subscription} from "rxjs/Subscription";
import {PetInfo, PetService} from "../../../../services/pet.service";
import {MedicalTestReportService} from "../../../../../medical-test/services/medical-test-report.service";
import {MedicalTestReportTemplateService} from "../../../../../medical-test/services/medical-test-report-template.service";
import {TreatmentCaseService} from "../../../../services/treatment-case.service";
import {PharmacyMedicineService} from "../../../../../pharmacy/services/pharmacy-medicine.service";
import {FinanceChargeService} from "../../../../../finance/services/finance-charge.service";
import {ReportStatusEnum} from "../../../../../medical-test/enums/report-status.enum";
import {MedicalTestReportTemplateItem} from "../../../../../medical-test/models/medical-test-report-template-item.model";

@Component({
  selector: 'app-pet-treatment-detail',
  templateUrl: './pet-treatment-detail.component.html',
  styleUrls: ['./pet-treatment-detail.component.css']
})
export class PetTreatmentDetailComponent implements OnChanges, OnInit, OnDestroy {


  @ViewChild("createMedicalTestReportModal")
  createMedicalTestReportModal: ModalComponent;
  @ViewChild("viewMedicalTestReportModal")
  viewMedicalTestReportModal: ModalComponent;
  @Input()
  treatmentCase: any;
  detailedTreatmentCase: any = {};
  treatmentCaseBasicInfoModel: FormGroup;
  formModel: FormGroup;

  medicineFormModel:FormGroup;

  medicalTestReportList: any[] = [];
  medicalTestReportUnsubmittedList: any[] = [];
  searchInput: FormControl = new FormControl('', [Validators.required, Validators.minLength(1)]);


  medicineSearchInput: FormControl = new FormControl('', [Validators.required, Validators.minLength(1)]);
  medicalTestReportTemplates: any[] = [];

  medicineSearchResults: any[] = [];
  selectedReportType: any;

  selectedReportId: string;

  petInfo: PetInfo;
  petInfoChangeSubscription: Subscription;
  prescriptions: any[] = [];

  pharmacyMedicineDispense:any={};


  ngOnDestroy(): void {
    this.petInfoChangeSubscription.unsubscribe();
  }

  constructor(private router: Router,
              private fb: FormBuilder,
              private medicalTestReportService: MedicalTestReportService,
              private medicalTestReportTemplateService: MedicalTestReportTemplateService,
              private petService: PetService,
              private treatmentCaseService: TreatmentCaseService,
              private pharmacyMedicineService:PharmacyMedicineService,
              private financeChargeService: FinanceChargeService) {

    this.petInfoChangeSubscription = petService.petInfoChange.subscribe(
      newPetInfo =>
        this.petInfo = newPetInfo);

    this.searchInput.valueChanges
      .debounceTime(200)
      .switchMap(name => {

        if (name === "") {
          return Observable.of([]);
        }
        else {
          return this.medicalTestReportTemplateService.findMedicalTestReportTemplateByNameContains(name);
        }
      })
      .subscribe(r => {
        this.medicalTestReportTemplates = r;
      })

    this.medicineSearchInput.valueChanges
      .debounceTime(200)
      .switchMap(name => {

        if (name === "") {
          return Observable.of([]);
        }
        else {
          return this.pharmacyMedicineService.findMedicineByNameContains(name);
        }
      })
      .subscribe(r => {
        this.medicineSearchResults = r;
      })
  }

  get reportInfoData() {
    return <FormArray>this.formModel.get('reportInfoList');
  }


  get medicineInfoData() {
    return <FormArray>this.medicineFormModel.get('items');
  }

  ngOnChanges(changes: SimpleChanges): void {
    this.loadData();
  }

  onRequestMedicalTest() {


  }

  stopPropagation($event) {
    event.stopPropagation()
  }

  onChooseReportTypeModalClosed() {

  }

  isRowSelected(report: any) {
    return this.selectedReportType === report;
  }

  onReportTypeSelected(report: any) {
    this.selectedReportType = report;
  }

  onMedicalTestReportTemplateSelected(medicalTestReportTemplate: any) {

    this.process(medicalTestReportTemplate);
    this.createMedicalTestReportModal.open();

  }

  onCreateMedicalTestReportModalClosed() {
    this.formModel.controls['petUuid'].setValue(this.petInfo.pet.uuid);
    this.formModel.controls['petOwnerUuid'].setValue(this.petInfo.petOwner.uuid);

    this.medicalTestReportService.createReport(this.formModel.value).subscribe(r => {
      this.loadData();
    });
  }

  ngOnInit(): void {
    this.initForm();
  }

  onSaveTreatmentCaseBasicInfo() {
    this.treatmentCaseService.update(this.detailedTreatmentCase.id, this.treatmentCaseBasicInfoModel.value).subscribe(r => {
      this.loadData();
    });

  }


  onMedicineSearchResultSelected(medicineSearchResult: any) {
    this.addMedicine(medicineSearchResult);
  }

  protected process(medicalTestReportTemplate: any) {

    let reportType = medicalTestReportTemplate.id;
    //this.initFormModel();
    this.initForm();

    this.medicalTestReportTemplateService.findById(reportType).subscribe(r => {

      this.formModel.controls['reportName'].setValue(r.reportName);
      this.formModel.controls['reportTemplateUuid'].setValue(r.uuid);
      this.formModel.controls['treatmentCaseUuid'].setValue(this.detailedTreatmentCase.uuid);

      r.reportTemplateInfoList.forEach(infoItem => {
        this.inflateReportInfo(infoItem);
      });
      r.reportTemplateItems.forEach(item => {
        this.inflateReportItem(item);
      });

    });
  }


  private loadData() {
    if (this.treatmentCase != null)
      this.treatmentCaseService.readOne(this.treatmentCase.id).subscribe(r => {
        this.detailedTreatmentCase = r;

        this.inflateTreatmentCaseBasicInfo(r);

        this.medicalTestReportService.findReportsByUuids(this.detailedTreatmentCase.medicalTestReportUuidList).subscribe(r => {
          this.medicalTestReportUnsubmittedList = r.filter(report => {
            return ReportStatusEnum[report.reportStatus] === ReportStatusEnum.UNSUBMITTED;
          })
          this.medicalTestReportList = r.filter(report => ReportStatusEnum[report.reportStatus] !== ReportStatusEnum.UNSUBMITTED)
        });

        this.inflateMedicineList(r);

      });
  }

  private inflateMedicineList(r:any)
  {
    r.medicineList.forEach(each=>
    {
      this.addMedicine(each);
    })
  }

  private inflateTreatmentCaseBasicInfo(r: any) {
    this.treatmentCaseBasicInfoModel.controls['id'].setValue(r.id);
    this.treatmentCaseBasicInfoModel.controls['petOwnerDescription'].setValue(r.petOwnerDescription);
    this.treatmentCaseBasicInfoModel.controls['clinicSituation'].setValue(r.clinicSituation);
    this.treatmentCaseBasicInfoModel.controls['doctorDiagnose'].setValue(r.doctorDiagnose);
    this.treatmentCaseBasicInfoModel.controls['doctorAdvice'].setValue(r.doctorAdvice);
  }

  private inflateReportItem(reportItem: MedicalTestReportTemplateItem) {
    const control = <FormArray>this.formModel.controls['reportItems'];

    control.push(this.fb.group({
      'itemName': [reportItem.itemName, Validators.required],
      'itemUnit': [reportItem.itemUnit, Validators.required],
      'referenceLowLimitValue': [reportItem.referenceLowLimitValue, Validators.required],
      'referenceHighLimitValue': [reportItem.referenceHighLimitValue, Validators.required],
      'comments': [reportItem.comments],
    }));

  }

  private inflateReportInfo(infoItem: any, rv: string = '') {
    const control = <FormArray>this.formModel.controls['reportInfoList'];
    control.push(this.fb.group({
      'reportKey': [infoItem.reportKey, Validators.required],
      'reportValue': [rv, Validators.required]
    }));
  }

  private initForm() {

    this.treatmentCaseBasicInfoModel = this.fb.group({
      'id': [''],
      'petOwnerDescription': [''],
      'clinicSituation': [''],
      'doctorDiagnose': [''],
      'doctorAdvice': ['']
    });
    this.initFormModel();
    this.initMedicineFormModel();
  }

  private initFormModel() {
    this.formModel = this.fb.group({
      'id': [''],
      'petOwnerUuid': [''],
      'petUuid': [''],
      'treatmentCaseUuid': [''],
      'reportTemplateUuid': [''],
      'reportName': ['', Validators.required],
      'reportInfoList': this.fb.array([]),
      //'reportType': ['', Validators.required],
      'reportItems': this.fb.array([]),
    })
  }

  private initMedicineFormModel() {
    this.medicineFormModel=this.fb.group({
      'items':this.fb.array([])
    });
  }


  addMedicine(medicineItem:any) {
    const control = <FormArray>this.medicineFormModel.controls['items'];
    control.push(this.initMedicineItem(medicineItem));
  }

  removeMedicine(i: number) {
    // remove address from the list
    const control = <FormArray>this.medicineFormModel.controls['items'];
    control.removeAt(i);
  }

  initMedicineItem(medicineItem:any) {

    return this.fb.group({
      'id': [''],
      'medicineId':[medicineItem.id, Validators.required],
      'uuid': [medicineItem.uuid, Validators.required],
      'name': [medicineItem.name, Validators.required],
      'unit': [medicineItem.unit, Validators.required],
      'specification':[medicineItem.specification, Validators.required],
      'amount':[,Validators.required]
    })
  }



  onAddReportFinished() {

    this.treatmentCaseService.generateMedicalTestOrder(this.detailedTreatmentCase.uuid).delay(1000).subscribe(r => {
      this.loadData();
    })

  }

  getMedicalTestReportStatus(medicalTestReport: any) {
    return ReportStatusEnum[medicalTestReport.reportStatus];
  }

  onRemoveReportClicked(medicalTestReport: any) {
    this.medicalTestReportService.removeReport(medicalTestReport.uuid).subscribe(r => {
      this.loadData();
    });
  }

  isMedicalTestFinished(medicalTestReport: any) {
    return ReportStatusEnum[medicalTestReport.reportStatus] === ReportStatusEnum.FINISHED;
  }

  onViewMedicalTestReportModalClosed() {
  }

  onViewMedicalTestReport(medicalTestReport: any) {
    this.selectedReportId = medicalTestReport.id;
    this.viewMedicalTestReportModal.open();
  }

  onAddPrescriptionFinished() {
    this.treatmentCaseService.setPrescriptions(this.treatmentCase.id,this.medicineFormModel.value).subscribe(r=>{this.loadData()});

  }

  onValueChanged(event: number, index:number, fieldName: string) {
    (<FormGroup>this.medicineInfoData.at(index)).controls["amount"].setValue(event);

  }

}
