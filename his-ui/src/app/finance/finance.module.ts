import {NgModule} from '@angular/core';

import {FinanceRoutingModule} from './finance-routing.module';
import {SharedModule} from "../shared/shared.module";
import {ChargeAdminDetailComponent} from "./components/charge-management/charge-admin-detail/charge-admin-detail.component";
import {ChargeManagementComponent} from "./components/charge-management/charge-management.component";
import {FinaceQueryComponent} from "./components/finace-query/finace-query.component";
import {PriceManagementComponent} from "./components/price-management/price-management.component";
import {FinanceComponent} from "./components/finance.component";
import {PriceAdminListComponent} from "./components/price-management/price-admin-list/price-admin-list.component";
import {FinancePriceManagementContainerComponent} from './containers/finance-price-management-container/finance-price-management-container.component';
import { FinancePriceManagementTreatmentContainerComponent } from './containers/finance-price-management-treatment-container/finance-price-management-treatment-container.component';
import { FinancePriceManagementMedicalTestContainerComponent } from './containers/finance-price-management-medical-test-container/finance-price-management-medical-test-container.component';
import { FinancePriceManagementInventoryContainerComponent } from './containers/finance-price-management-inventory-container/finance-price-management-inventory-container.component';

@NgModule({
  imports: [
    SharedModule,
    FinanceRoutingModule
  ],
  declarations: [
    ChargeAdminDetailComponent,
    ChargeManagementComponent,
    FinaceQueryComponent,
    PriceManagementComponent,
    FinanceComponent,
    PriceAdminListComponent,
    FinancePriceManagementContainerComponent,
    FinancePriceManagementTreatmentContainerComponent,
    FinancePriceManagementMedicalTestContainerComponent,
    FinancePriceManagementInventoryContainerComponent,
  ]
})
export class FinanceModule {
}
