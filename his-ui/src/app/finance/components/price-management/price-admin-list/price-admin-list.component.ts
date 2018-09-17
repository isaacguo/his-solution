import {Component, OnInit} from '@angular/core';
import {FinancePriceService} from "../../../../core/services/finance-price.service";

@Component({
  selector: 'app-price-admin-list',
  templateUrl: './price-admin-list.component.html',
  styleUrls: ['./price-admin-list.component.css']
})
export class PriceAdminListComponent implements OnInit {


  selectedModule: string = "请选择模块";
  modules: any[] = ["请选择模块", "化验模块", "库房模块", "药房模块"];


  constructor(public financePriceService: FinancePriceService) {

  }

  ngOnInit(): void {

  }

  setSelectedModule(module: string) {
    this.selectedModule = module;
  }
}
