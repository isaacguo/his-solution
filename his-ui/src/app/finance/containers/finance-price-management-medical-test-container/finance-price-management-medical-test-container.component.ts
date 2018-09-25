import {Component, OnInit} from '@angular/core';
import {FinancePriceService} from "../../../core/services/finance/finance-price.service";

@Component({
  selector: 'app-finance-price-management-medical-test-container',
  templateUrl: './finance-price-management-medical-test-container.component.html',
  styleUrls: ['./finance-price-management-medical-test-container.component.css']
})
export class FinancePriceManagementMedicalTestContainerComponent implements OnInit {

  constructor(public  financePriceService: FinancePriceService) {
  }

  ngOnInit() {
  }

}
