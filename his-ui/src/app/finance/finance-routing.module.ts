import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {FinancePriceManagementContainerComponent} from "./containers/finance-price-management-container/finance-price-management-container.component";
import {FinancePriceManagementTreatmentContainerComponent} from "./containers/finance-price-management-treatment-container/finance-price-management-treatment-container.component";
import {FinancePriceManagementMedicalTestContainerComponent} from "./containers/finance-price-management-medical-test-container/finance-price-management-medical-test-container.component";
import {FinancePriceManagementInventoryContainerComponent} from "./containers/finance-price-management-inventory-container/finance-price-management-inventory-container.component";
import {FinanceChargeManagementContainerComponent} from "./containers/finance-charge-management-container/finance-charge-management-container.component";

const routes: Routes = [
  {
    path: 'charge-management',
    component: FinanceChargeManagementContainerComponent
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
      {
        path: '**',
        redirectTo: 'treatment',
      }

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
