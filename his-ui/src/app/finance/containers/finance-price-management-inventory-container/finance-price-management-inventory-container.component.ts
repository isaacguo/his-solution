import {Component, OnInit} from '@angular/core';
import {FinancePriceService} from "../../../core/services/finance/finance-price.service";

@Component({
  selector: 'app-finance-price-management-inventory-container',
  templateUrl: './finance-price-management-inventory-container.component.html',
  styleUrls: ['./finance-price-management-inventory-container.component.css']
})
export class FinancePriceManagementInventoryContainerComponent implements OnInit {

  constructor(public financePriceService: FinancePriceService) {
  }

  ngOnInit() {
  }

}
