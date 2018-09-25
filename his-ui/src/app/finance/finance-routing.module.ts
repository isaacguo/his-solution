import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {FinanceManagementGuard} from "../core/guards/finance/finance-management.guard";
import {FinanceComponent} from "./components/finance.component";
import {ChargeManagementGuard} from "../core/guards/finance/charge-management.guard";
import {ChargeManagementComponent} from "./components/charge-management/charge-management.component";
import {FinancePriceManagementContainerComponent} from "./containers/finance-price-management-container/finance-price-management-container.component";
import {FinancePriceManagementTreatmentContainerComponent} from "./containers/finance-price-management-treatment-container/finance-price-management-treatment-container.component";
import {FinancePriceManagementMedicalTestContainerComponent} from "./containers/finance-price-management-medical-test-container/finance-price-management-medical-test-container.component";
import {FinancePriceManagementInventoryContainerComponent} from "./containers/finance-price-management-inventory-container/finance-price-management-inventory-container.component";

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
    component: FinancePriceManagementContainerComponent,
    children: [
      {
        path: 'treatment',
        component: FinancePriceManagementTreatmentContainerComponent
      },
      {
        path: 'medical-test',
        component: FinancePriceManagementMedicalTestContainerComponent,
      },
      {
        path: 'inventory',
        component: FinancePriceManagementInventoryContainerComponent
      },

    ]
  }
  /*
  {
    path: 'price-management',
    canActivate: [PriceManagementGuard],
    component: PriceManagementComponent
  },
  */
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FinanceRoutingModule {
}
