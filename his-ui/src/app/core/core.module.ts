import {NgModule} from '@angular/core';

import {AuthenticationService} from "./services/common/authentication.service";
import {AuthorizationService} from "./services/common/authorization.service";
import {Http, RequestOptions} from "@angular/http";
import {AuthConfig, AuthHttp} from "angular2-jwt";
import {SharedModule} from "../shared/shared.module";
import {TreeNodeService} from "./services/common/tree-node.service";
import {HashLocationStrategy, LocationStrategy} from "@angular/common";
import {AdminGuard} from "../auth/guards/admin.guard";
import {AuthGuard, LogoutGuardService} from "../auth/guards/auth.guard";
import {ProcurementManagementGuard} from "./guards/procurement/procurement-management.guard";
import {ProcurementApprovalGuard} from "./guards/procurement/procurement-approval.guard";
import {FrontdeskGuard} from "./guards/treatement/frontdesk.guard";
import {TreatmentSettingsGuard} from "./guards/treatement/treatment-settings.guard";
import {InpatientManagementGuard} from "./guards/treatement/inpatient-management.guard";
import {MyConsultingRoomGuard} from "./guards/treatement/my-consulting-room.guard";
import {EmployeeManagementGuard} from "./guards/employee/employee-management.guard";
import {ChargeManagementGuard} from "./guards/finance/charge-management.guard";
import {FinanceManagementGuard} from "./guards/finance/finance-management.guard";
import {MedicalTestManagementGuard} from "./guards/medical-test/medical-test-management.guard";
import {InventoryManagementGuard} from "./guards/inventory/inventory-management.guard";
import {ProcurementApprovalService} from "./services/procurement/procurement-approval.service";
import {EmployeeService} from "./services/employee/employee.service";
import {PriceManagementGuard} from "./guards/finance/price-management.guard";
import {MedicineManagementGuard} from "./guards/medicine/medicine-management.guard";
import {FinancePriceService} from "./services/finance/finance-price.service";
import {FinanceChargeService} from "./services/finance/finance-charge.service";
import {PetService} from "./services/treatment/pet.service";
import {EmployeeDepartmentService} from "./services/employee/employee-department.service";


export function authHttpServiceFactory(http: Http, options: RequestOptions) {
  return new AuthHttp(new AuthConfig({
    headerName: "Authorization",
    headerPrefix: "Bearer",
    tokenName: "id_token",
    tokenGetter: (() => sessionStorage.getItem("id_token")),
    globalHeaders: [{'Content-Type': 'application/json'}],
    noJwtError: true,
    noTokenScheme: true
  }), http, options);
}

@NgModule({
  imports: [
    SharedModule,
  ],
  declarations: [],
  providers: [
    {
      provide: AuthHttp, useFactory: authHttpServiceFactory, deps: [Http, RequestOptions]
    },
    {provide: LocationStrategy, useClass: HashLocationStrategy},
    AuthorizationService,
    AuthenticationService,
    TreeNodeService,
    AdminGuard,
    AuthGuard,
    LogoutGuardService,
    ProcurementApprovalService,
    EmployeeService,
    FinancePriceService,
    FinanceChargeService,
    PetService,
    EmployeeDepartmentService,
    ProcurementApprovalGuard,
    ProcurementManagementGuard,
    FrontdeskGuard,
    InpatientManagementGuard,
    MyConsultingRoomGuard,
    TreatmentSettingsGuard,
    EmployeeManagementGuard,
    ChargeManagementGuard,
    PriceManagementGuard,
    FinanceManagementGuard,
    MedicalTestManagementGuard,
    InventoryManagementGuard,
    MedicineManagementGuard
  ]
})
export class CoreModule {
}
