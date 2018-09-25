import {Component, OnInit} from '@angular/core';
import {FinancePriceService} from "../../../core/services/finance/finance-price.service";

@Component({
  selector: 'app-finance-price-management-treatment-container',
  templateUrl: './finance-price-management-treatment-container.component.html',
  styleUrls: ['./finance-price-management-treatment-container.component.css']
})
export class FinancePriceManagementTreatmentContainerComponent implements OnInit {

  constructor(financePriceService: FinancePriceService) {

  }

  ngOnInit() {
  }

}
