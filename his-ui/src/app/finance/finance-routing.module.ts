import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {FinanceManagementGuard} from "../core/guards/finance/finance-management.guard";
import {FinanceComponent} from "./components/finance.component";
import {ChargeManagementGuard} from "../core/guards/finance/charge-management.guard";
import {ChargeManagementComponent} from "./components/charge-management/charge-management.component";
import {PriceManagementGuard} from "../core/guards/finance/price-management.guard";
import {PriceManagementComponent} from "./components/price-management/price-management.component";

const routes: Routes = [
  {
    path: 'finance',
    canActivate: [FinanceManagementGuard],
    component: FinanceComponent,
  },
  {
    path: 'charge-management',
    canActivate: [ChargeManagementGuard],
    component: ChargeManagementComponent
  },
  {
    path: 'price-management',
    canActivate: [PriceManagementGuard],
    component: PriceManagementComponent
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FinanceRoutingModule {
}
