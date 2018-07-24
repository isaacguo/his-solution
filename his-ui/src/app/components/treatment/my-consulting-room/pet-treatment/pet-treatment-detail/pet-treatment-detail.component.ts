import {Component, Input, OnChanges, OnInit, SimpleChanges, ViewChild} from '@angular/core';
import {TreatmentCaseService} from "../../../../../services/treatment/treatment-case.service";
import {Router} from "@angular/router";
import {MedicalTestReportService} from "../../../../../services/medical-test/medical-test-report.service";
import {MedicalTestReportTemplateService} from "../../../../../services/medical-test/medical-test-report-template.service";
import {FormArray, FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {Observable} from "rxjs/Observable";
import {ModalComponent} from "ng2-bs3-modal/ng2-bs3-modal";
import {MedicalTestReportTemplateItem} from "../../../../../dto/medical-test/medical-test-report-template-item.model";
import {ReportStatusEnum} from "../../../../../enums/report-status.enum";
import {FinanceChargeService} from "../../../../../services/finance/finance-charge.service";
import {ChargeOperationRequest} from "../../../../../dto/finance/charge-operation-request.model";
import {ChargeItemRequest} from "../../../../../dto/finance/charge-item-request.model";

@Component({
  selector: 'app-pet-treatment-detail',
  templateUrl: './pet-treatment-detail.component.html',
  styleUrls: ['./pet-treatment-detail.component.css']
})
export class PetTreatmentDetailComponent implements OnChanges, OnInit {


  @ViewChild("createMedicalTestReportModal")
  createMedicalTestReportModal: ModalComponent;
  @Input()
  treatmentCase: any;
  detailedTreatmentCase: any = {};
  treatmentCaseBasicInfoModel: FormGroup;
  formModel: FormGroup;
  medicalTestReportList: any[] = [];
  medicalTestReportUnsubmittedList: any[] = [];
  searchInput: FormControl = new FormControl('', [Validators.required, Validators.minLength(1)]);
  medicineSearchInput: FormControl = new FormControl('', [Validators.required, Validators.minLength(1)]);
  medicalTestReportTemplates: any[] = [];
  medicineSearchResults: any[] = [];
  selectedReportType: any;

  constructor(private router: Router,
              private fb: FormBuilder,
              private medicalTestReportService: MedicalTestReportService,
              private medicalTestReportTemplateService: MedicalTestReportTemplateService,
              private treatmentCaseService: TreatmentCaseService,
              private financeChargeService: FinanceChargeService) {

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
          return this.medicalTestReportTemplateService.findMedicalTestReportTemplateByNameContains(name);
        }
      })
      .subscribe(r => {
        this.medicalTestReportTemplates = r;
      })
  }

  get reportInfoData() {
    return <FormArray>this.formModel.get('reportInfoList');
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
    this.medicalTestReportService.createReport(this.formModel.value).subscribe(r => {
      this.treatmentCaseService.addMedicalTestReport(this.treatmentCase.id, r.id).subscribe(z => {
        this.loadData();
      })
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

  }

  protected process(medicalTestReportTemplate: any) {

    let reportType = medicalTestReportTemplate.id;

    this.medicalTestReportTemplateService.findById(reportType).subscribe(r => {
      //this.reportTemplate = r;

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

        this.medicalTestReportService.findReportsByIds(this.detailedTreatmentCase.medicalTestReportIdList).subscribe(r => {
          this.medicalTestReportUnsubmittedList = r.filter(report => {
            return ReportStatusEnum[report.reportStatus] === ReportStatusEnum.UNSUBMITTED;
          })
          this.medicalTestReportList = r.filter(report => ReportStatusEnum[report.reportStatus] !== ReportStatusEnum.UNSUBMITTED)
        });
      });
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
    this.formModel = this.fb.group({
      'id': [''],
      'treatmentCaseUuid':[''],
      'reportTemplateUuid':[''],
      'reportName': ['', Validators.required],
      'reportInfoList': this.fb.array([]),
      //'reportType': ['', Validators.required],
      'reportItems': this.fb.array([]),
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
}
