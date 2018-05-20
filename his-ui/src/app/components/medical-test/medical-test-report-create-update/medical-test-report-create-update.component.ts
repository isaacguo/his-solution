import {Component, OnInit} from '@angular/core';
import {AbstractCreateUpdateComponent} from "../../common/abstract-create-update.component";
import {ActivatedRoute, Router} from "@angular/router";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {MedicalTestReportService} from "../../../services/medical-test/medical-test-report.service";
import {OperationEnum} from "../../../enums/operation.enum";
import {observable} from "rxjs/symbol/observable";
import {MedicalTestReport} from "../../../dto/medical-test/medical-test-report.model";

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

    this.process();
    this.initForm();
  }

  private initForm() {
    this.formModel = this.fb.group({
      'id': [''],
      'reportType': ['', Validators.required],
      'report':this.fb.group(
        {
          reportItems:this.fb.array([


          ])
        }
      )
    })
  }

  reportTemplate: MedicalTestReport;

  protected process() {

    this.route.params.subscribe(params => {
      this.operation = OperationEnum[<string>params['operation']];
      if (this.operation === OperationEnum.CREATE) {
        this.reportType = params['reportType'];

        this.medicalTestReportService.findById(this.reportType).subscribe(r => {
          this.reportTemplate=r;
          this.formModel.controls['reportType'].setValue(this.reportTemplate.reportName);
        });
      }
    });
  }


}
