import {NgModule} from '@angular/core';

import {FinanceRoutingModule} from './finance-routing.module';
import {SharedModule} from "../shared/shared.module";
import {FinanceChargeManagementContainerComponent} from './containers/finance-charge-management-container/finance-charge-management-container.component';
import {FinanceChargeManagementComponent} from './components/finance-charge-management/finance-charge-management.component';

import {FinancePriceManagementContainerComponent} from './containers/finance-price-management-container/finance-price-management-container.component';
import {FinancePriceManagementTreatmentContainerComponent} from './containers/finance-price-management-treatment-container/finance-price-management-treatment-container.component';
import {FinancePriceManagementMedicalTestContainerComponent} from './containers/finance-price-management-medical-test-container/finance-price-management-medical-test-container.component';
import {FinancePriceManagementInventoryContainerComponent} from './containers/finance-price-management-inventory-container/finance-price-management-inventory-container.component';
import {FinanceQueryComponent} from "./components/finance-query/finance-query.component";
import {ChargeManagementComponent} from "./components/charge-management/charge-management.component";
import {ChargeAdminDetailComponent} from "./components/charge-management/charge-admin-detail/charge-admin-detail.component";
import {PriceAdminListComponent} from "./components/price-management/price-admin-list/price-admin-list.component";
import {PriceManagementComponent} from "./components/price-management/price-management.component";

@NgModule({
  imports: [
    SharedModule,
    FinanceRoutingModule
  ],
  declarations: [
    FinancePriceManagementContainerComponent,
    FinancePriceManagementTreatmentContainerComponent,
    FinancePriceManagementMedicalTestContainerComponent,
    FinancePriceManagementInventoryContainerComponent,

    FinanceQueryComponent,

    PriceManagementComponent,

    ChargeManagementComponent,

    FinanceChargeManagementContainerComponent,
    FinanceChargeManagementComponent,
    ChargeAdminDetailComponent,
    PriceAdminListComponent]

})
export class FinanceModule {
}
