import {Component, Input, OnInit} from '@angular/core';
import {FinancePriceService} from "../../../../core/services/finance/finance-price.service";
import {InventoryCategoryService} from "../../../../core/services/inventory/inventory-category.service";
import {AbstractCategoryListComponent} from "../../../../shared/abstract-category-list/abstract-category-list.component";

@Component({
  selector: 'app-inventory-settings-item-management',
  templateUrl: './inventory-settings-item-management.component.html',
  styleUrls: ['./inventory-settings-item-management.component.css']
})
export class InventorySettingsItemManagementComponent extends AbstractCategoryListComponent implements OnInit {

  @Input()
  canDelete: boolean = true;
  @Input()
  canEdit: boolean = true;
  @Input()
  financePriceService: FinancePriceService;

  @Input()
  canShowAmount: boolean = false;

  @Input()
  canCreateNewItem: boolean = true;

  constructor(inventoryCategoryService: InventoryCategoryService) {
    super(inventoryCategoryService);

  }


  onNodeActivated(event) {
    super.onNodeActivated(event);
  }


}
