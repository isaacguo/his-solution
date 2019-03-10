import {Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges} from '@angular/core';
import {FormArray, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {MedicalTestReportTemplateItem} from "../../models/medical-test-report-template-item.model";
import {MedicalTestReport} from "../../models/medical-test-report.model";

@Component({
  selector: 'app-medical-test-report-update',
  templateUrl: './medical-test-report-update.component.html',
  styleUrls: ['./medical-test-report-update.component.css']
})
export class MedicalTestReportUpdateComponent implements OnInit, OnChanges {

  formModel: FormGroup;

  @Input()
  medicalTestReport: MedicalTestReport;
  @Output()
  updateTestReport = new EventEmitter<any>();

  constructor(
    public route: ActivatedRoute,
    private fb: FormBuilder,
    public router: Router
  ) {
  }

  ngOnInit() {
    this.initForm();
  }

  private initForm() {
    this.formModel = this.fb.group({
      'uuid': [''],
      'markAsDone': [false],
      'reportName': ['', Validators.required],
      'reportInfoList': this.fb.array([]),
      //'reportType': ['', Validators.required],
      'reportItems': this.fb.array([]),
    })
  }


  get reportInfoData() {
    return <FormArray>this.formModel.get('reportInfoList');
  }

  get reportData() {
    return <FormArray>this.formModel.get('reportItems');
  }

  private inflateReportInfo(infoItem: any, rv: string = '') {
    const control = <FormArray>this.formModel.controls['reportInfoList'];
    control.push(this.fb.group({
      'reportKey': [infoItem.reportKey, Validators.required],
      'reportValue': [rv, Validators.required]
    }));
  }

  private inflateReportItem(reportItem: MedicalTestReportTemplateItem) {
    const control = <FormArray>this.formModel.controls['reportItems'];

    control.push(this.fb.group({
      'id': [reportItem.id, Validators.required],
      'itemName': [reportItem.itemName, Validators.required],
      'itemUnit': [reportItem.itemUnit, Validators.required],
      'referenceLowLimitValue': [reportItem.referenceLowLimitValue, Validators.required],
      'referenceHighLimitValue': [reportItem.referenceHighLimitValue, Validators.required],
      'result': [reportItem.result ? reportItem.result : "", Validators.required],
      'comments': [reportItem.comments],
    }));
  }

  ngOnChanges(changes: SimpleChanges): void {
    if (changes['medicalTestReport'] && this.medicalTestReport) {

      this.formModel.controls['uuid'].setValue(this.medicalTestReport.uuid);
      this.formModel.controls['reportName'].setValue(this.medicalTestReport.reportName);

      this.medicalTestReport.reportItems.forEach(item => {
        this.inflateReportItem(item);
      })
    }
  }

  onSubmit() {
    this.updateTestReport.emit(this.formModel.value);
  }
}
