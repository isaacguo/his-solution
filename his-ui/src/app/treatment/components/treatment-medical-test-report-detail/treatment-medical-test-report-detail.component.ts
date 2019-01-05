import {Component, Input, OnInit, SimpleChanges} from '@angular/core';
import {FormArray, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {MedicalTestReport} from "../../../medical-test/models/medical-test-report.model";
import {ActivatedRoute, Router} from "@angular/router";
import {MedicalTestReportTemplateItem} from "../../../medical-test/models/medical-test-report-template-item.model";

@Component({
  selector: 'app-treatment-medical-test-report-detail',
  templateUrl: './treatment-medical-test-report-detail.component.html',
  styleUrls: ['./treatment-medical-test-report-detail.component.css']
})
export class TreatmentMedicalTestReportDetailComponent implements OnInit {

  formModel: FormGroup;
  @Input()
  medicalTestReport: MedicalTestReport;

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

      this.formModel.controls['reportItems'] = this.fb.array([])

      this.medicalTestReport.reportItems.forEach(item => {
        this.inflateReportItem(item);
      })
    }
  }
}
