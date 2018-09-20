import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {FormArray, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {MedicalTestReportService} from "../../../core/services/medical-test/medical-test-report.service";
import {MedicalTestReportTemplateService} from "../../../core/services/medical-test/medical-test-report-template.service";
import {AbstractCreateUpdateComponent} from "../../../shared/abstract-create-update.component";
import {OperationEnum} from "../../../core/enums/operation.enum";
import {MedicalTestReportTemplateItem} from "../../models/medical-test-report-template-item.model";

@Component({
  selector: 'app-medical-test-report-create-update',
  templateUrl: './medical-test-report-create-update.component.html',
  styleUrls: ['./medical-test-report-create-update.component.css']
})
export class MedicalTestReportCreateUpdateComponent extends AbstractCreateUpdateComponent implements OnInit {


  formModel: FormGroup;
  reportType: number;

  invokeWhenCreate() {
    this.medicalTestReportService.createReport(this.formModel.value).subscribe(r => {
      this.router.navigate(['medical-test-query']);
    });

  }

  invokeWhenUpdate() {
    this.medicalTestReportService.updateReport(this.formModel.value).subscribe(r => {
      this.router.navigate(['medical-test-query']);
    });
  }

  constructor(public route: ActivatedRoute,
              private fb: FormBuilder,
              public router: Router,
              private medicalTestReportTemplateService: MedicalTestReportTemplateService,
              private medicalTestReportService: MedicalTestReportService) {
    super(route);
  }

  ngOnInit() {

    this.initForm();
    this.process();
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

  private initReportInfoList() {
    return this.fb.group({
      'id': [''],
      'reportKey': ['', Validators.required],
      'reportValue': ['', Validators.required]
    })
  }

  reportTemplate: any;

  protected process() {

    this.route.params.subscribe(params => {
      this.operation = OperationEnum[<string>params['operation']];
      this.reportType = params['reportType'];
      if (this.operation === OperationEnum.CREATE) {

        this.medicalTestReportTemplateService.findById(this.reportType).subscribe(r => {
          this.reportTemplate = r;

          this.formModel.controls['reportName'].setValue(r.reportName);

          r.reportTemplateItems.forEach(item => {
            this.inflateReportItem(item);
          });

          r.reportTemplateInfoList.forEach(infoItem => {
            this.inflateReportInfo(infoItem);
          });
        });
      }
      else { //Update
        this.medicalTestReportService.findById(this.reportType).subscribe(r => {

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
    });
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

    if (this.isCreateMode()) {
      control.push(this.fb.group({
        'itemName': [reportItem.itemName, Validators.required],
        'itemUnit': [reportItem.itemUnit, Validators.required],
        'referenceLowLimitValue': [reportItem.referenceLowLimitValue, Validators.required],
        'referenceHighLimitValue': [reportItem.referenceHighLimitValue, Validators.required],
        'comments': [reportItem.comments],
      }));
    }
    else {
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
  }
}
