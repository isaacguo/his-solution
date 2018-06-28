import {Component, Input, OnChanges, OnInit, SimpleChanges, ViewChild} from '@angular/core';
import {TreatmentCaseService} from "../../../../../services/treatment/treatment-case.service";
import {Router} from "@angular/router";
import {MedicalTestReportService} from "../../../../../services/medical-test/medical-test-report.service";
import {MedicalTestReportTemplateService} from "../../../../../services/medical-test/medical-test-report-template.service";
import {FormArray, FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {Observable} from "rxjs/Observable";
import {OperationEnum} from "../../../../../enums/operation.enum";
import {ModalComponent} from "ng2-bs3-modal/ng2-bs3-modal";
import {MedicalTestReportTemplateItem} from "../../../../../dto/medical-test/medical-test-report-template-item.model";

@Component({
  selector: 'app-pet-treatment-detail',
  templateUrl: './pet-treatment-detail.component.html',
  styleUrls: ['./pet-treatment-detail.component.css']
})
export class PetTreatmentDetailComponent implements OnChanges, OnInit {


  ngOnChanges(changes: SimpleChanges): void {
    this.loadData();
  }

  @ViewChild("createMedicalTestReportModal")
  createMedicalTestReportModal: ModalComponent;

  @Input()
  treatmentCase: any;
  detailedTreatmentCase: any = {};

  formModel: FormGroup;

  constructor(private router: Router,
              private fb: FormBuilder,
              private medicalTestReportService: MedicalTestReportService,
              private medicalTestReportTemplateService: MedicalTestReportTemplateService,
              private treatmentCaseService: TreatmentCaseService) {

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

  }

  medicalTestReportList: any[] = [];

  private loadData() {
    if (this.treatmentCase != null)
      this.treatmentCaseService.readOne(this.treatmentCase.id).subscribe(r => {
        this.detailedTreatmentCase = r;

        this.medicalTestReportService.findReportsByIds(this.detailedTreatmentCase.medicalTestReportIdList).subscribe(r=>{
          this.medicalTestReportList=r;
        });
      });
  }

  onRequestMedicalTest() {


  }

  searchInput: FormControl = new FormControl('', [Validators.required, Validators.minLength(1)]);

  medicalTestReportTemplates: any[] = [];

  stopPropagation($event) {
    event.stopPropagation()
  }

  onChooseReportTypeModalClosed() {

  }

  selectedReportType: any;

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
      console.log(r);
      this.treatmentCaseService.addMedicalTestReport(this.treatmentCase.id, r.id).subscribe(z => {
        this.loadData();
      })
    });
  }

  get reportInfoData() {
    return <FormArray>this.formModel.get('reportInfoList');
  }

  ngOnInit(): void {

    this.initForm();
  }

  protected process(medicalTestReportTemplate: any) {

    let reportType = medicalTestReportTemplate.id;

    this.medicalTestReportTemplateService.findById(reportType).subscribe(r => {
      //this.reportTemplate = r;

      this.formModel.controls['reportName'].setValue(r.reportName);

      r.reportTemplateInfoList.forEach(infoItem => {
        this.inflateReportInfo(infoItem);
      });
      r.reportTemplateItems.forEach(item => {
        this.inflateReportItem(item);
      });
    });
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
    this.formModel = this.fb.group({
      'id': [''],
      'reportName': ['', Validators.required],
      'reportInfoList': this.fb.array([]),
      //'reportType': ['', Validators.required],
      'reportItems': this.fb.array([]),
    })
  }
}
