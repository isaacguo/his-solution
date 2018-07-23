import {Component, OnInit} from '@angular/core';
import {FinancePriceService} from "../../../../services/finance/finance-price.service";
import {FinanceChargeService} from "../../../../services/finance/finance-charge.service";

@Component({
  selector: 'app-charge-admin-list',
  templateUrl: './charge-admin-list.component.html',
  styleUrls: ['./charge-admin-list.component.css']
})
export class ChargeAdminListComponent implements OnInit {


  chargeItems: any[] = [];

  constructor(public financeChargeService: FinanceChargeService) {


  }

  loadData() {
    this.financeChargeService.readAll().subscribe(r => {
      this.chargeItems = r;
    })
  }

  ngOnInit(): void {
    this.loadData();

  }

}
