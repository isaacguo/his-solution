import {NgModule} from '@angular/core';
import {IndexContainerComponent} from './containers/index-container/index-container.component';
import {IndexComponent} from './components/index/index.component';
import {SharedModule} from "../shared/shared.module";
import {TreatmentCaseService} from "./services/treatment/treatment-case.service";
import {AuthConfig, AuthHttp} from "angular2-jwt";
import {Http, RequestOptions} from "@angular/http";
import {AuthenticationService} from "./services/common/authentication.service";
import {AuthorizationService} from "./services/common/authorization.service";
import {EmployeeDepartmentService} from "./services/employee/employee-department.service";
import {TreeNodeService} from "./services/common/tree-node.service";
import {EmployeeService} from "./services/employee/employee.service";
import {FactoryResetService} from "./services/settings/factory-reset.service";
import {PetOwnerService} from "./services/treatment/pet-owner.service";
import {TreatmentDepartmentService} from "./services/treatment/treatment-department.service";
import {TreatmentEmployeeService} from "./services/treatment/treatment-employee.service";
import {RegistrationService} from "./services/treatment/registration.service";
import {PetService} from "./services/treatment/pet.service";
import {EmployeeManagementGuard} from "./guards/employee/employee-management.guard";
import {ChargeManagementGuard} from "./guards/finance/charge-management.guard";
import {FinanceManagementGuard} from "./guards/finance/finance-management.guard";
import {PriceManagementGuard} from "./guards/finance/price-management.guard";
import {InventoryManagementGuard} from "./guards/inventory/inventory-management.guard";
import {MedicalTestManagementGuard} from "./guards/medical-test/medical-test-management.guard";
import {MedicineManagementGuard} from "./guards/medicine/medicine-management.guard";
import {ProcurementManagementGuard} from "./guards/procurement/procurement-management.guard";
import {FrontdeskGuard} from "./guards/treatement/frontdesk.guard";
import {InpatientManagementGuard} from "./guards/treatement/inpatient-management.guard";
import {MyConsultingRoomGuard} from "./guards/treatement/my-consulting-room.guard";
import {TreatmentSettingsGuard} from "./guards/treatement/treatment-settings.guard";
import {ProcurementApprovalGuard} from "./guards/procurement/procurement-approval.guard";
import {GuardFactoryService} from "./services/guard-factory.service";


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
    SharedModule
  ],
  declarations: [
    //containers
    IndexContainerComponent,

    //components
    IndexComponent,

    ],
  providers: [
    {
      provide: AuthHttp, useFactory: authHttpServiceFactory, deps: [Http, RequestOptions]
    },
    TreatmentCaseService,
    AuthorizationService,
    AuthenticationService,
    TreeNodeService,
    EmployeeDepartmentService,
    EmployeeService,
    FactoryResetService,
    PetOwnerService,
    PetService,
    TreatmentDepartmentService,
    TreatmentEmployeeService,
    RegistrationService,
    EmployeeManagementGuard,
    ChargeManagementGuard,
    FinanceManagementGuard,
    PriceManagementGuard,
    InventoryManagementGuard,
    MedicalTestManagementGuard,
    MedicineManagementGuard,
    MedicineManagementGuard,
    ProcurementManagementGuard,
    FrontdeskGuard,
    InpatientManagementGuard,
    MyConsultingRoomGuard,
    TreatmentSettingsGuard,
    ProcurementApprovalGuard,
    GuardFactoryService




  ]

})
export class CoreModule {
}
