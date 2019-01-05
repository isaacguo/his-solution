import {Component, Input, OnInit} from '@angular/core';
import {InventoryCategoryService} from "../../../../core/services/inventory/inventory-category.service";
import {FinancePriceService} from "../../../../core/services/finance/finance-price.service";
import {AbstractCategoryListComponent} from "../../../../shared/components/abstract-category-list/abstract-category-list.component";

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
  financePriceService: FinancePriceService;
  @Input()
  canShowAmount:boolean=true;
  @Input()
  canCreateNewItem: boolean = true;



  constructor(inventoryCategoryService: InventoryCategoryService)
  {
    super(inventoryCategoryService);

  }


  onNodeActivated(event) {
    super.onNodeActivated(event);
  }
}
