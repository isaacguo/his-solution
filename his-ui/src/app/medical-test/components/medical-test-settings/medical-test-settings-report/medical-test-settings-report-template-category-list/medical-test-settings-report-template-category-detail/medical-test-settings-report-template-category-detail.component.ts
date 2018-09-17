import {Component, Input, OnChanges, OnInit, SimpleChanges, ViewChild} from '@angular/core';
import {ModalComponent} from "ng2-bs3-modal/ng2-bs3-modal";
import {Router} from "@angular/router";
import {MedicalTestReportTemplate} from "../../../../../models/medical-test-report-template.model";
import {MedicalTestReportTemplateCategoryService} from "../../../../../services/medical-test-report-template-category.service";
import {MedicalTestReportTemplateService} from "../../../../../services/medical-test-report-template.service";
import {FinancePriceService} from "../../../../../../core/services/finance-price.service";

@Component({
  selector: 'app-medical-test-settings-report-template-category-detail',
  templateUrl: './medical-test-settings-report-template-category-detail.component.html',
  styleUrls: ['./medical-test-settings-report-template-category-detail.component.css']
})
export class MedicalTestSettingsReportTemplateCategoryDetailComponent implements OnInit, OnChanges {

  @Input()
  canCreateNewItem: boolean = true;
  @Input()
  canDelete: boolean = true;
  @Input()
  canEdit: boolean = true;
  @Input()
  financePriceService: FinancePriceService;


  @Input()
  categoryName: string;
  @Input()
  categoryId: number;
  @ViewChild("confirmDeletionModal") confirmDeletionModal: ModalComponent;

  medicalTestReports: MedicalTestReportTemplate[];

  constructor(public router: Router,
              private medicalTestReportTemplateCategoryService: MedicalTestReportTemplateCategoryService,
              private medicalTestReportService: MedicalTestReportTemplateService) {

  }

  ngOnInit() {
  }

  loadData() {

    if (this.categoryId !== undefined && this.categoryId !== null) {
      if (this.financePriceService !== undefined) {
        this.medicalTestReportTemplateCategoryService.readOne(this.categoryId).mergeMap(category => {
          return this.financePriceService.findByUuids(category.reportTemplateList.map(m => m.uuid)).map(list => ({
            'category': category,
            'list': list
          }))
        })
          .subscribe(r => {

            r.list.forEach(b => {
                let item = r.category.reportTemplateList.find(r => r.uuid === b["priceItemUuid"]);
                if (item != null) {
                  item.normalPrice = b["normalPrice"];
                  item.memberPrice = b["memberPrice"];
                }
              }
            );
            this.medicalTestReports = r.category.reportTemplateList;
          })
      }
      else {

        this.medicalTestReportTemplateCategoryService.readOne(this.categoryId).subscribe(r => {
          this.medicalTestReports = r.reportTemplateList;
        })
      }
    }

  }

  onCreateNewReportClicked() {
    this.router.navigate(['medical-test-settings', 'report-templates', OperationEnum.CREATE, this.categoryId]);
  }


  onEditButtonClicked(report: MedicalTestReportTemplate) {
    this.router.navigate(['medical-test-settings', 'report-templates', OperationEnum.UPDATE, report.id]);
  }

  reportToBeDeleted: MedicalTestReportTemplate;

  removeReport(report: MedicalTestReportTemplate) {

    this.reportToBeDeleted = report;
    this.confirmDeletionModal.open();
  }

  onConfirmDeletionModalClosed() {
    this.medicalTestReportService.deleteById(this.reportToBeDeleted.id).subscribe(r => {
      this.loadData();
    })
  }

  ngOnChanges(changes: SimpleChanges): void {
    this.loadData();
  }


  onValueChanged(event: number, report, fieldName: string) {
    //console.log(event);
    //console.log(report);
    let obj = {};
    obj[fieldName] = event;
    obj['uuid'] = report.uuid;
    this.financePriceService.updateValue(obj).subscribe(r => {

    });
  }


}
