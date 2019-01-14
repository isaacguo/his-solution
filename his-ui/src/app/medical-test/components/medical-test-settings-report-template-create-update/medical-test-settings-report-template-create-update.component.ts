import {ChangeDetectionStrategy, Component, OnChanges, OnDestroy, OnInit, ViewChild} from '@angular/core';
import {AbstractCreateUpdateComponent} from "../../../shared/components/abstract-create-update-component/abstract-create-update.component";
import {ModalComponent} from "ng2-bs3-modal/ng2-bs3-modal";
import {FormArray, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {MedicalTestReportTemplateService} from "../../../core/services/medical-test/medical-test-report-template.service";
import {OperationEnum} from "../../../core/enums/operation.enum";
import {MedicalTestReportTemplateItem} from "../../models/medical-test-report-template-item.model";
import {BehaviorSubject, Observable} from "rxjs";
import {PopupModalBundle} from "../../../shared/models/popup-modal-bundle.model";

@Component({
  selector: 'app-medical-test-settings-report-template-create-update',
  templateUrl: './medical-test-settings-report-template-create-update.component.html',
  styleUrls: ['./medical-test-settings-report-template-create-update.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class MedicalTestSettingsReportTemplateCreateUpdateComponent extends AbstractCreateUpdateComponent implements OnInit {


  reportCreationResultText = "";
  @ViewChild("confirmCreateModal") confirmCreateModal: ModalComponent;
  formModel: FormGroup;
  popupBundleSubject = new BehaviorSubject<PopupModalBundle>({});
  bundle$: Observable<PopupModalBundle> = this.popupBundleSubject.asObservable();
  categoryId: number;

  constructor(public route: ActivatedRoute,
              private fb: FormBuilder,
              public router: Router,
              private medicalTestReportService: MedicalTestReportTemplateService) {
    super(route);

  }

  get reportData() {
    return <FormArray>this.formModel.get('reportItems');
  }

  get reportInfoData() {
    return <FormArray>this.formModel.get('reportInfo');
  }

  invokeWhenCreate() {


    this.formModel.controls['categoryId'].setValue(this.categoryId);

    this.medicalTestReportService.createReport(this.formModel.value).subscribe(r => {
      if (r.id > 0) {

        this.popupBundleSubject.next({
          title: '信息',
          body: '<h4>化验报告模板信息添加成功</h4>',
          hasConfirmButton: true,
          confirmButtonText: "确定",
        })
      }
    });
  }

  onModalClosed() {
    this.router.navigate(['medical-tests', this.categoryId], {relativeTo: this.route.parent});
  }

  invokeWhenUpdate() {
    this.medicalTestReportService.updateReport(this.formModel.value).subscribe(r => {
      if (r.id > 0) {
        this.popupBundleSubject.next({
          title: '信息',
          body: '<h4>化验报告模板信息更新成功</h4>',
          hasConfirmButton: true,
          confirmButtonText: "确定",
        })

      }
    })
  }

  ngOnInit() {
    this.initForm();
    this.process();


    this.route.params.take(1).subscribe(params => {
      this.categoryId = params['categoryId'];
    });


    if (this.operation === OperationEnum.UPDATE) {

      this.medicalTestReportService.findById(this.updateId).subscribe(r => {
        this.inflateFormModelWithValues(r);

        this.clearReportItems();
        r.reportTemplateItems.forEach(contact => {
          this.inflateReportItem(contact);
        });
        /*
        r.reportTemplateInfoList.forEach(infoItem => {
          this.inflateReportInfo(infoItem);
        });
        */

      });
    }
  }

  clearReportItems() {
    let control = <FormArray>this.formModel.controls['reportItems'];
    this.clearFormArray(control);

    let control2 = <FormArray>this.formModel.controls['reportInfo'];

    this.clearFormArray(control2);


  }

  clearFormArray(formArray: FormArray) {
    while (formArray.length !== 0) {
      formArray.removeAt(0)
    }
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

  addReportItem() {
    const control = <FormArray>this.formModel.controls['reportItems'];
    control.push(this.initReportItem());
  }

  addReportInfoItem() {
    const control = <FormArray>this.formModel.controls['reportInfo'];
    control.push(this.initReportInfoItem());
  }

  removeReportItem(i) {
    const control = <FormArray>this.formModel.controls['reportItems'];
    control.removeAt(i);
  }

  removeReportInfoItem(i) {
    const control = <FormArray>this.formModel.controls['reportInfo'];
    control.removeAt(i);
  }

  private inflateReportInfo(infoItem: any) {
    const control = <FormArray>this.formModel.controls['reportInfo'];

    control.push(this.fb.group({
      'reportKey': [infoItem.reportKey],
    }));
  }

  private inflateFormModelWithValues(r) {
    this.formModel.controls['id'].setValue(r.id);
    this.formModel.controls['categoryId'].setValue(this.categoryId);
    this.formModel.controls['reportName'].setValue(r.reportName);
  }

  private initForm() {
    this.formModel = this.fb.group({
      'categoryId': [''],
      'id': [''],
      'reportName': ['', Validators.required],
      'reportInfo': this.fb.array([
        this.initReportInfoItem()
      ]),
      'reportItems': this.fb.array([
        this.initReportItem()
      ]),
    })
  }

  private initReportInfoItem() {
    return this.fb.group({
      'id': [''],
      'reportKey': ['']
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


}
