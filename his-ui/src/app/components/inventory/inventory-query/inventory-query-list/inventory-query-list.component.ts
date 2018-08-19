import {Component, Input, OnInit} from '@angular/core';
import {AbstractCategoryListComponent} from "../../../common/abstract-category-list/abstract-category-list.component";
import {MedicalTestReportTemplateCategoryService} from "../../../../services/medical-test/medical-test-report-template-category.service";
import {InventoryCategoryService} from "../../../../services/inventory/inventory-category.service";
import {FinancePriceService} from "../../../../services/finance/finance-price.service";

@Component({
  selector: 'app-inventory-query-list',
  templateUrl: './inventory-query-list.component.html',
  styleUrls: ['./inventory-query-list.component.css']
})
export class InventoryQueryListComponent extends AbstractCategoryListComponent implements OnInit {

  @Input()
  canDelete: boolean = true;
  @Input()
  canEdit: boolean = true;
  @Input()
  financeChargeService: FinancePriceService;
  @Input()
  canShowAmount:boolean=true;
  @Input()
  canCreateNewItem: boolean = true;



  constructor(inventoryCategoryService: InventoryCategoryService) {
    super(inventoryCategoryService);

  }


  onNodeActivated(event) {
    super.onNodeActivated(event);
  }
}
