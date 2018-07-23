import {Component, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {AbstractCategoryListComponent} from "../../../../common/abstract-category-list/abstract-category-list.component";
import {MedicalTestReportTemplateCategoryService} from "../../../../../services/medical-test/medical-test-report-template-category.service";
import {FinancePriceService} from "../../../../../services/finance/finance-price.service";

@Component({
  selector: 'app-medical-test-settings-report-template-category-list',
  templateUrl: './medical-test-settings-report-template-category-list.component.html',
  styleUrls: ['./medical-test-settings-report-template-category-list.component.css']
})
export class MedicalTestSettingsReportTemplateCategoryListComponent extends AbstractCategoryListComponent implements OnInit {
  @Input()
  canDelete: boolean = true;
  @Input()
  canEdit: boolean = true;
  @Input()
  financeChargeService:FinancePriceService;

  @Input()
  canCreateNewItem: boolean = true;

  constructor(medicalTestReportTemplateCategoryService: MedicalTestReportTemplateCategoryService) {
    super(medicalTestReportTemplateCategoryService);

  }

  onNodeActivated(event) {
    super.onNodeActivated(event);
  }

}
