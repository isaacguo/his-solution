import {Component, Input, OnInit} from '@angular/core';
import {FinancePriceService} from "../../../core/services/finance/finance-price.service";
import {AbstractCategoryListComponent} from "../../abstract-category-list/abstract-category-list.component";
import {ChargeableCategoryService} from "../../../core/services/treatment/chargeable-category.service";

@Component({
  selector: 'app-treatment-settings-chargeable-category',
  templateUrl: './treatment-settings-chargeable-category.component.html',
  styleUrls: ['./treatment-settings-chargeable-category.component.css']
})
export class TreatmentSettingsChargeableCategoryComponent extends AbstractCategoryListComponent implements OnInit {

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

  constructor(chargeableCategoryService: ChargeableCategoryService) {
    super(chargeableCategoryService);

  }


  onNodeActivated(event) {
    super.onNodeActivated(event);
  }
}
