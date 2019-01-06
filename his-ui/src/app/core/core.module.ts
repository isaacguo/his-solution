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
import {CommentService} from "./services/treatment/comment.service";
import {MedicalTestReportTemplateService} from "./services/medical-test/medical-test-report-template.service";
import {MedicalTestReportTemplateCategoryService} from "./services/medical-test/medical-test-report-template-category.service";
import {FinancePriceService} from "./services/finance/finance-price.service";
import {FinanceChargeService} from "./services/finance/finance-charge.service";
import {MedicalTestReportService} from "./services/medical-test/medical-test-report.service";
import {InventoryCategoryService} from "./services/inventory/inventory-category.service";
import {InventoryExportSheetService} from "./services/inventory/inventory-export-sheet.service";
import {InventoryImportSheetService} from "./services/inventory/inventory-import-sheet.service";
import {InventoryItemService} from "./services/inventory/inventory-item.service";
import {ProductImportReceiptService} from "./services/inventory/product-import-receipt.service";
import {PharmacyPrescriptionService} from "./services/pharmacy/pharmacy-prescription.service";
import {PharmacyMedicineService} from "./services/pharmacy/pharmacy-medicine.service";


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
    CommentService,
    MedicalTestReportTemplateService,
    FinancePriceService,
    FinanceChargeService,
    InventoryCategoryService,
    InventoryExportSheetService,
    InventoryImportSheetService,
    InventoryItemService,
    ProductImportReceiptService,

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
    GuardFactoryService,
    MedicalTestReportTemplateCategoryService,
    MedicalTestReportService,
    PharmacyPrescriptionService,
    PharmacyMedicineService

  ]

})
export class CoreModule {
}
