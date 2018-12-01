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
import {GuardFactoryService} from "./services/guard-factory.service";
import {DataManagementService} from "./services/gateway/data-management.service";
import {MedicalTestDepartmentService} from "./services/medical-test/medical-test-department.service";


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
    DataManagementService,
    MedicalTestDepartmentService,
    /*
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
    */
    GuardFactoryService




  ]

})
export class CoreModule {
}
