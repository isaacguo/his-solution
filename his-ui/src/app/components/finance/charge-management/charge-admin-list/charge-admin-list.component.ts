import {Component, OnInit} from '@angular/core';
import {FinanceChargeService} from "../../../../services/finance/finance-charge.service";

@Component({
  selector: 'app-charge-admin-list',
  templateUrl: './charge-admin-list.component.html',
  styleUrls: ['./charge-admin-list.component.css']
})
export class ChargeAdminListComponent implements OnInit {


  selectedModule: string = "请选择模块";
  modules: any[] = ["请选择模块", "化验模块"];

  constructor(public financeChargeService: FinanceChargeService) {

  }

  ngOnInit(): void {

  }

  setSelectedModule(module: string) {
    console.log(module);
    this.selectedModule = module;
  }
}
