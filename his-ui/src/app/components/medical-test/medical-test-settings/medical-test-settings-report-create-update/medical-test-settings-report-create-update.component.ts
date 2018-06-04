import {Component, OnInit, ViewChild} from '@angular/core';
import {AbstractCreateUpdateComponent} from "../../../common/abstract-create-update.component";
import {ActivatedRoute, Router} from "@angular/router";
import {FormArray, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {MedicalTestReportService} from "../../../../services/medical-test/medical-test-report-template.service";
import {ModalComponent} from "ng2-bs3-modal/ng2-bs3-modal";
import {OperationEnum} from "../../../../enums/operation.enum";
import {Contact} from "../../../../dto/procurement/contact.model";
import {MedicalTestReportTemplateItem} from "../../../../dto/medical-test/medical-test-report-template-item.model";

@Component({
  selector: 'app-medical-test-settings-report-create-update',
  templateUrl: './medical-test-settings-report-create-update.component.html',
  styleUrls: ['./medical-test-settings-report-create-update.component.css']
})
export class MedicalTestSettingsReportCreateUpdateComponent extends AbstractCreateUpdateComponent implements OnInit {


  reportCreationResultText = "";
  @ViewChild("confirmCreateModal") confirmCreateModal: ModalComponent;
  formModel: FormGroup;

  constructor(public route: ActivatedRoute,
              private fb: FormBuilder,
              public router: Router,
              private medicalTestReportService: MedicalTestReportService) {
    super(route);
  }

  invokeWhenCreate() {
    this.medicalTestReportService.createReport(this.formModel.value).subscribe(r => {
      if (r.id > 0) {
        this.reportCreationResultText = "化验报告模板信息添加成功";
        this.confirmCreateModal.open();
      }

    });
  }

  onConfirmCreateModalClosed() {
    this.router.navigate(['medical-test-settings', 'reports']);
  }

  invokeWhenUpdate() {


  }

  ngOnInit() {
    this.initForm();
    this.process();

    if (this.operation === OperationEnum.UPDATE) {
      this.medicalTestReportService.findById(this.updateId).subscribe(r => {
        this.inflatFormModelWithValues(r);
        this.clearReportItems();
        r.reportTemplateItems.forEach(contact => {
          this.inflateReportItem(contact);
        })
      })

    }
  }

  private inflatFormModelWithValues(r) {
    this.formModel.controls['id'].setValue(r.id);
    this.formModel.controls['reportName'].setValue(r.reportName);
  }

  clearReportItems() {
    const control = <FormArray>this.formModel.controls['reportItems'];
    control.controls = [];
  }

  inflateReportItem(reportItem: MedicalTestReportTemplateItem) {
    const control = <FormArray>this.formModel.controls['reportItems'];

    control.push(this.fb.group({
      'itemName': [reportItem.itemName, Validators.required],
      'itemUnit': [reportItem.itemUnit, Validators.required],
      'referenceLowLimitValue': [reportItem.referenceLowLimitValue, Validators.required],
      'referenceHighLimitValue': [reportItem.referenceHighLimitValue, Validators.required],
      'comments': [reportItem.comments],
    }));
  }

  private initForm() {
    this.formModel = this.fb.group({
      'id': [''],
      'reportName': ['', Validators.required],
      'reportItems': this.fb.array([
        this.initReportItem()
      ]),
    })
  }

  private initReportItem() {
    return this.fb.group({
      'id': [''],
      'itemName': ['', Validators.required],
      'itemUnit': ['', Validators.required],
      'referenceLowLimitValue': ['', Validators.required],
      'referenceHighLimitValue': ['', Validators.required],
      'comments': ['']
    })
  }

  addReportItem() {
    const control = <FormArray>this.formModel.controls['reportItems'];
    control.push(this.initReportItem());
  }


  get reportData() {
    return <FormArray>this.formModel.get('reportItems');
  }

  removeReportItem(i) {
    // remove address from the list
    const control = <FormArray>this.formModel.controls['reportItems'];
    control.removeAt(i);
  }

}
