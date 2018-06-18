import {Component, OnInit} from '@angular/core';
import {AbstractCreateUpdateComponent} from "../../common/abstract-create-update.component";
import {ActivatedRoute, Router} from "@angular/router";
import {FormArray, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {MedicalTestReportService} from "../../../services/medical-test/medical-test-report-template.service";
import {OperationEnum} from "../../../enums/operation.enum";
import {observable} from "rxjs/symbol/observable";
import {MedicalTestReportTemplate} from "../../../dto/medical-test/medical-test-report-template.model";
import {MedicalTestReportTemplateItem} from "../../../dto/medical-test/medical-test-report-template-item.model";

@Component({
  selector: 'app-medical-test-report-create-update',
  templateUrl: './medical-test-report-create-update.component.html',
  styleUrls: ['./medical-test-report-create-update.component.css']
})
export class MedicalTestReportCreateUpdateComponent extends AbstractCreateUpdateComponent implements OnInit {


  formModel: FormGroup;
  reportType: number;

  invokeWhenCreate() {


  }

  invokeWhenUpdate() {
  }

  constructor(public route: ActivatedRoute,
              private fb: FormBuilder,
              public router: Router,
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
      'reportInfoList': this.fb.array([
      ]),
      //'reportType': ['', Validators.required],
      'reportItems': this.fb.array([
      ]),
    })
  }

  private initReportInfoList() {
    return this.fb.group({
      'id': [''],
      'reportKey': ['', Validators.required],
      'reportValue':['',Validators.required]
    })
  }

  reportTemplate: any;

  protected process() {

    this.route.params.subscribe(params => {
      this.operation = OperationEnum[<string>params['operation']];
      if (this.operation === OperationEnum.CREATE) {
        this.reportType = params['reportType'];

        this.medicalTestReportService.findById(this.reportType).subscribe(r => {

          console.log(r);
          this.reportTemplate = r;

          r.reportTemplateItems.forEach( item=> {
            this.inflateReportItem(item);
          });
          r.reportTemplateInfoList.forEach(infoItem => {
            this.inflateReportInfo(infoItem);
          });

        });
      }
    });
  }

  get reportInfoData()
  {
    return <FormArray>this.formModel.get('reportInfoList');
  }
  get reportData() {
    return <FormArray>this.formModel.get('reportItems');
  }


  private inflateReportInfo(infoItem: any) {
    const control = <FormArray>this.formModel.controls['reportInfoList'];
    control.push(this.fb.group({
      'reportKey': [infoItem.reportKey, Validators.required],
      'reportValue':['',Validators.required]
    }));
  }

  private inflateReportItem(reportItem: MedicalTestReportTemplateItem) {
    const control = <FormArray>this.formModel.controls['reportItems'];

    control.push(this.fb.group({
      'itemName': [reportItem.itemName, Validators.required],
      'itemUnit': [reportItem.itemUnit, Validators.required],
      'referenceLowLimitValue': [reportItem.referenceLowLimitValue, Validators.required],
      'referenceHighLimitValue': [reportItem.referenceHighLimitValue, Validators.required],
      'result':['',Validators.required],
      'comments': [reportItem.comments],
    }));

  }
}
