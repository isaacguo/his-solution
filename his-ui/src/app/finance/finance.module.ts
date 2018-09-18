import {NgModule} from '@angular/core';

import {FinanceRoutingModule} from './finance-routing.module';
import {SharedModule} from "../shared/shared.module";
import {ChargeAdminDetailComponent} from "./components/charge-management/charge-admin-detail/charge-admin-detail.component";
import {ChargeAdminListComponent} from "./components/charge-management/charge-admin-list/charge-admin-list.component";
import {ChargeManagementComponent} from "./components/charge-management/charge-management.component";
import {FinaceQueryComponent} from "./components/finace-query/finace-query.component";
import {PriceManagementComponent} from "./components/price-management/price-management.component";
import {FinanceComponent} from "./components/finance.component";
import {PriceAdminListComponent} from "./components/price-management/price-admin-list/price-admin-list.component";

@NgModule({
  imports: [
    SharedModule,
    FinanceRoutingModule
  ],
  declarations: [
    ChargeAdminDetailComponent,
    ChargeAdminListComponent,
    ChargeManagementComponent,
    FinaceQueryComponent,
    PriceManagementComponent,
    FinanceComponent,
    PriceAdminListComponent,
  ]
})
export class FinanceModule { }
