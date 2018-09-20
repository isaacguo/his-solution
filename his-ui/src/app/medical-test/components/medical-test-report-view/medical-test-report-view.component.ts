import {Component, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {FormArray, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {MedicalTestReportTemplateService} from "../../../core/services/medical-test/medical-test-report-template.service";
import {MedicalTestReportService} from "../../../core/services/medical-test/medical-test-report.service";
import {MedicalTestReportTemplateItem} from "../../models/medical-test-report-template-item.model";

@Component({
  selector: 'app-medical-test-report-view',
  templateUrl: './medical-test-report-view.component.html',
  styleUrls: ['./medical-test-report-view.component.css']
})
export class MedicalTestReportViewComponent implements OnInit, OnChanges {

  formModel: FormGroup;
  @Input()
  medicalTestReportId: string;


  constructor(
    private fb: FormBuilder,
    private medicalTestReportTemplateService: MedicalTestReportTemplateService,
    private medicalTestReportService: MedicalTestReportService) {
  }

  ngOnInit() {


  }

  process() {
    if(this.medicalTestReportId==undefined || this.medicalTestReportId==null)
    {
      return;
    }
    this.medicalTestReportService.findById(this.medicalTestReportId).subscribe(r => {

      this.formModel.controls['id'].setValue(r.id);
      this.formModel.controls['reportName'].setValue(r.reportName);

      r.reportInfoList.forEach(infoItem => {
        this.inflateReportInfo(infoItem, infoItem.reportValue);
      });

      r.reportItems.forEach(item => {
        this.inflateReportItem(item);
      });

    });
  }

  private initForm() {
    this.formModel = this.fb.group({
      'id': [''],
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
    this.initForm();
    this.process();
  }

}
