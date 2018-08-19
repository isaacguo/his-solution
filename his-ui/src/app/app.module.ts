import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';


import {AppComponent} from './app.component';
import {IndexComponent} from './components/index/index.component';
import {LoginComponent} from './components/login/login.component';
import {routing} from "../app.routing";
import {Http, HttpModule, RequestOptions} from "@angular/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HashLocationStrategy, LocationStrategy} from "@angular/common";
import {TreatmentComponent} from './components/treatment/treatment.component';
import {ProfilesComponent} from './components/profiles/profiles.component';
import {PetsComponent} from './components/pets/pets.component';
import {BusinessComponent} from './components/business/business.component';
import {InventoryComponent} from './components/inventory/inventory.component';
import {AnalysisComponent} from './components/analysis/analysis.component';
import {DataComponent} from './components/data/data.component';
import {SettingsComponent} from './components/settings/settings.component';
import {TestingComponent} from './components/testing/testing.component';
import {PharmacyComponent} from './components/pharmacy/pharmacy.component';
import {ImagesComponent} from './components/images/images.component';
import {MembersComponent} from './components/members/members.component';
import {LogoutComponent} from './components/logout/logout.component';
import {AuthConfig, AuthHttp} from "angular2-jwt";
import {AuthGuard, LogoutGuardService} from "./guards/auth.guard";
import {AuthenticationService} from "./services/common/authentication.service";
import {EmployeeComponent} from './components/employee/employee.component';
import {EmployeeService} from "./services/employee/employee.service";
import {EmployeeProfileComponent} from './components/employee/employee-profile/employee-profile.component';
import {EmployeeLeaveComponent} from './components/employee/employee-leave/employee-leave.component';
import {DashboardComponent} from './components/dashboard/dashboard.component';
import {EmployeeProfileEditComponent} from './components/employee/employee-profile-edit/employee-profile-edit.component';
import {EmployeeAdminComponent} from './components/employee/employee-admin/employee-admin.component';
import {AdminGuard} from "./guards/admin.guard";
import {FinanceComponent} from './components/finance/finance.component';
import {RegisterComponent} from './components/treatment/register/register.component';
import {DoctorRegistrationComponent} from './components/treatment/doctor-registration/doctor-registration.component';
import {DoctorListViewComponent} from './components/treatment/doctor-registration/views/doctor-list-view/doctor-list-view.component';
import {TimeBasedViewComponent} from './components/treatment/doctor-registration/views/time-based-view/time-based-view.component';
import {DoctorListItemComponent} from './components/treatment/doctor-registration/views/doctor-list-view/doctor-list-item/doctor-list-item.component';
import {MyConsultingRoomComponent} from './components/treatment/my-consulting-room/my-consulting-room.component';
import {DepartmentService} from "./services/treatment/department.service";
import {Ng2Bs3ModalModule} from "ng2-bs3-modal/ng2-bs3-modal";
import {FrontDeskComponent} from "./components/treatment/front-desk/front-desk.component";
import {PetRegistrationComponent} from './components/treatment/front-desk/pet-registration/pet-registration.component';
import {PetOwnerService} from "./services/treatment/pet-owner.service";
import {RegistrationService} from "./services/treatment/registration.service";
import {TreatmentEmployeeService} from "./services/treatment/treatment-employee.service";
import {PetService} from "./services/treatment/pet.service";
import {PetInfoComponent} from './components/treatment/my-consulting-room/pet-info/pet-info.component';
import {PetTreatmentComponent} from './components/treatment/my-consulting-room/pet-treatment/pet-treatment.component';
import {InventoryQueryComponent} from './components/inventory/inventory-query/inventory-query.component';
import {TreeModule} from "angular-tree-component";
import {ProcurementManagementComponent} from './components/procurement/procurement-management/procurement-management.component';
import {ProcurementSettingsComponent} from './components/procurement/procurement-settings/procurement-settings.component';
import {VendorManagementComponent} from './components/procurement/procurement-settings/vendor-management/vendor-management.component';
import {VendorCreateUpdateComponent} from './components/procurement/procurement-settings/vendor-create-update/vendor-create-update.component';
import {ContactCreateUpdateComponent} from './components/procurement/procurement-settings/vendor-create-update/contact-create-update/contact-create-update.component';
import {VendorService} from "./services/procurement/vendor.service";
import {ProcurementStatusService} from "./services/procurement/procurement-status.service";
import {ProcurementStatusComponent} from './components/procurement/procurement-settings/procurement-status/procurement-status.component';
import {ProcurementRequestComponent} from './components/procurement/procurement-request/procurement-request.component';
import {ProcurementApprovalComponent} from './components/procurement/procurement-approval/procurement-approval.component';
import {ProcurementWorkflowComponent} from './components/procurement/procurement-settings/procurement-workflow/procurement-workflow.component';
import {ProcurementRequestCreateUpdateComponent} from './components/procurement/procurement-request/procurement-request-create-update/procurement-request-create-update.component';
import {ProcurementRequestDetailComponent} from './components/procurement/procurement-request/procurement-request-detail/procurement-request-detail.component';
import {RequestGoodComponent} from './components/procurement/procurement-request/procurement-request-create-update/request-good/request-good.component';
import {ProcurementRequestService} from "./services/procurement/procurement-request.service";
import {ProcurementService} from "./services/procurement/procurement.service";
import {ProcurementApprovalService} from "./services/procurement/procurement-approval.service";
import {ProcurementApprovalListComponent} from './components/procurement/procurement-approval/procurement-approval-list/procurement-approval-list.component';
import {ProcurementApprovalDetailComponent} from './components/procurement/procurement-approval/procurement-approval-detail/procurement-approval-detail.component';
import {ProcurementTableListViewComponent} from './components/procurement/procurement-approval/procurement-table-list-view/procurement-table-list-view.component';
import {ProcurementPurchaseComponent} from './components/procurement/procurement-purchase/procurement-purchase.component';
import {ProcurementPurchaseListComponent} from './components/procurement/procurement-purchase/procurement-purchase-list/procurement-purchase-list.component';
import {ProcurementPurchaseCreateUpdateComponent} from './components/procurement/procurement-purchase/procurement-purchase-create-update/procurement-purchase-create-update.component';
import {ProcurementPurchaseGoodCreateUpdateComponent} from './components/procurement/procurement-purchase/procurement-purchase-create-update/procurement-purchase-good-create-update/procurement-purchase-good-create-update.component';
import {ProcurementPurchaseDetailComponent} from './components/procurement/procurement-purchase/procurement-purchase-detail/procurement-purchase-detail.component';
import {ProcurementRequestDetailTableComponent} from './components/procurement/procurement-request/procurement-request-detail/procurement-request-detail-table/procurement-request-detail-table.component';
import {AngularSplitModule} from "angular-split";
import {MyDatePickerModule} from "mydatepicker";
import {AuthorizationManagementComponent} from './components/settings/authorization-management/authorization-management.component';
import {SecurityOperationPanelComponent} from './components/settings/authorization-management/security-operation-panel/security-operation-panel.component';
import {AuthorizationService} from "./services/common/authorization.service";
import {VendorProductCategoryComponent} from './components/procurement/procurement-settings/vendor-product-category/vendor-product-category.component';
import {CategoryListComponent} from './components/procurement/procurement-settings/vendor-product-category/category-list/category-list.component';
import {CategoryDetailComponent} from './components/procurement/procurement-settings/vendor-product-category/category-detail/category-detail.component';
import {VendorCategoryService} from "./services/procurement/vendor-category.service";
import {EmployeeDepartmentService} from "./services/employee/employee-department.service";
import {UiSwitchModule} from "ngx-ui-switch";
import {VendorGuard} from "./guards/procurement/vendor.guard";
import {EmployeeCreateUpdateComponent} from './components/employee/employee-create-update/employee-create-update.component';
import {EmployeeAdminListComponent} from './components/employee/employee-admin/employee-admin-list/employee-admin-list.component';
import {EmployeeAdminDetailComponent} from './components/employee/employee-admin/employee-admin-detail/employee-admin-detail.component';
import {EmployeeManagementGuard} from "./guards/employee/employee-management.guard";
import {ProcurementApprovalGuard} from "./guards/procurement/procurement-approval.guard";
import {FactoryResetComponent} from './components/settings/factory-reset/factory-reset.component';
import {FactoryResetService} from "./services/settings/factory-reset.service";
import {FrontdeskGuard} from "./guards/treatment/frontdesk.guard";
import {MyConsultingRoomGuard} from "./guards/treatment/my-consulting-room.guard";
import {TreatmentSettingsComponent} from './components/treatment/treatment-settings/treatment-settings.component';
import {TreatmentSettingsRoomComponent} from './components/treatment/treatment-settings/treatment-settings-room/treatment-settings-room.component';
import {TreatmentRoomListComponent} from './components/treatment/treatment-settings/treatment-settings-room/treatment-room-list/treatment-room-list.component';
import {TreatmentRoomDetailComponent} from './components/treatment/treatment-settings/treatment-settings-room/treatment-room-detail/treatment-room-detail.component';
import {TreeNodeService} from "./services/common/tree-node.service";
import {TreatmentSettingsGuard} from "./guards/treatment/treatment-settings.guard";
import {TreatmentRoomEmployeeListComponent} from './components/treatment/treatment-settings/treatment-settings-room/treatment-room-detail/treatment-room-employee-list/treatment-room-employee-list.component';
import {TreatmentRoomEmployeeDetailComponent} from './components/treatment/treatment-settings/treatment-settings-room/treatment-room-detail/treatment-room-employee-list/treatment-room-employee-detail/treatment-room-employee-detail.component';
import {MyConsultingRoomRegistrationListComponent} from './components/treatment/my-consulting-room/my-consulting-room-registration-list/my-consulting-room-registration-list.component';
import {MyConsultingRoomRegistrationDetailComponent} from './components/treatment/my-consulting-room/my-consulting-room-registration-list/my-consulting-room-registration-detail/my-consulting-room-registration-detail.component';
import {MedicalTestQueryComponent} from './components/medical-test/medical-test-query/medical-test-query.component';
import {MedicalTestSettingsComponent} from "./components/medical-test/medical-test-settings/medical-test-settings.component";
import {MedicalTestSettingsReportComponent} from './components/medical-test/medical-test-settings/medical-test-settings-report/medical-test-settings-report.component';
import {MedicalTestSettingsReportCreateUpdateComponent} from './components/medical-test/medical-test-settings/medical-test-settings-report-create-update/medical-test-settings-report-create-update.component';
import {MedicalTestReportTemplateService} from "./services/medical-test/medical-test-report-template.service";
import {MedicalTestReportCreateUpdateComponent} from './components/medical-test/medical-test-report-create-update/medical-test-report-create-update.component';
import {FinanceManagementGuard} from "./guards/finance/finance-management.guard";
import {InpatientManagementGuard} from "./guards/treatment/inpatient-management.guard";
import {MedicineManagementGuard} from "./guards/medicine/medicine-management.guard";
import {InpatientComponent} from "./components/inpatient/inpatient.component";
import {MedicalTestManagementGuard} from "./guards/medical-test/medical-test-management.guard";
import {ProcurementManagementGuard} from "./guards/procurement/procurement-management.guard";
import {EmployeeAdminListOnlyComponent} from './components/employee/employee-admin/employee-admin-list-only/employee-admin-list-only.component';
import {MedicalTestReportService} from "./services/medical-test/medical-test-report.service";
import {MedicalTestSettingsDepartmentComponent} from './components/medical-test/medical-test-settings/medical-test-settings-department/medical-test-settings-department.component';
import {MedicalTestSettingsDepartmentListComponent} from './components/medical-test/medical-test-settings/medical-test-settings-department/medical-test-settings-department-list/medical-test-settings-department-list.component';
import {MedicalTestSettingsDepartmentDetailComponent} from './components/medical-test/medical-test-settings/medical-test-settings-department/medical-test-settings-department-detail/medical-test-settings-department-detail.component';
import {MedicalTestDepartmentService} from "./services/medical-test/medical-test-department.service";
import {MedicalTestSettingsDepartmentReportTemplatesComponent} from './components/medical-test/medical-test-settings/medical-test-settings-department/medical-test-settings-department-detail/medical-test-settings-department-report-templates/medical-test-settings-department-report-templates.component';
import {PetMedicalTestComponent} from './components/treatment/my-consulting-room/pet-medical-test/pet-medical-test.component';
import {TreatmentCaseService} from "./services/treatment/treatment-case.service";
import {PetTreatmentDetailComponent} from './components/treatment/my-consulting-room/pet-treatment/pet-treatment-detail/pet-treatment-detail.component';
import {RegistrationQueryComponent} from './components/treatment/front-desk/registration-query/registration-query.component';
import {NgxPaginationModule} from "ngx-pagination";
import {FeeQueryComponent} from './components/treatment/front-desk/fee-query/fee-query.component';
import {QueryBarComponent} from './components/common/query-bar/query-bar.component';
import {ChargeManagementComponent} from './components/finance/charge-management/charge-management.component';
import {ChargeManagementGuard} from "./guards/finance/charge-management.guard";
import {FinaceQueryComponent} from './components/finance/finace-query/finace-query.component';
import {ChargeAdminListComponent} from './components/finance/charge-management/charge-admin-list/charge-admin-list.component';
import {ChargeAdminDetailComponent} from './components/finance/charge-management/charge-admin-detail/charge-admin-detail.component';
import {FinancePriceService} from "./services/finance/finance-price.service";
import {InventoryManagementGuard} from "./guards/medicine/inventory-management.guard";
import {MedicalTestSettingsReportTemplateCategoryListComponent} from './components/medical-test/medical-test-settings/medical-test-settings-report/medical-test-settings-report-template-category-list/medical-test-settings-report-template-category-list.component';
import {MedicalTestSettingsReportTemplateCategoryDetailComponent} from './components/medical-test/medical-test-settings/medical-test-settings-report/medical-test-settings-report-template-category-list/medical-test-settings-report-template-category-detail/medical-test-settings-report-template-category-detail.component';
import {MedicalTestReportTemplateCategoryService} from "./services/medical-test/medical-test-report-template-category.service";
import {FieldEditComponent} from './components/common/field-edit/field-edit.component';
import {ImportManagementComponent} from './components/inventory/import-management/import-management.component';
import {ExportManagementComponent} from './components/inventory/export-management/export-management.component';
import {InventorySettingsComponent} from './components/inventory/inventory-settings/inventory-settings.component';
import {ImportManagementListComponent} from './components/inventory/import-management/import-management-list/import-management-list.component';
import {ImportManagementDetailComponent} from './components/inventory/import-management/import-management-list/import-management-detail/import-management-detail.component';
import {InventoryOperationToolBarComponent} from './components/inventory/inventory-operation-tool-bar/inventory-operation-tool-bar.component';
import {ProductImportReceiptService} from "./services/inventory/product-import-receipt.service";
import {PriceManagementComponent} from './components/finance/price-management/price-management.component';
import {PriceAdminListComponent} from './components/finance/price-management/price-admin-list/price-admin-list.component';
import {PriceManagementGuard} from "./guards/finance/price-management.guard";
import {FinanceChargeService} from "./services/finance/finance-charge.service";
import {MedicalTestReportViewComponent} from './components/medical-test/medical-test-report-view/medical-test-report-view.component';
import {InventorySettingsWarehourseComponent} from './components/inventory/inventory-settings/inventory-settings-warehourse/inventory-settings-warehourse.component';
import {InventoryQueryListComponent} from './components/inventory/inventory-query/inventory-query-list/inventory-query-list.component';
import {InventoryCategoryService} from "./services/inventory/inventory-category.service";
import {InventoryItemService} from "./services/inventory/inventory-item.service";
import {InventoryItemCreateUpdateComponent} from './components/inventory/inventory-item-create-update/inventory-item-create-update.component';
import {ImportSheetCreateUpdateComponent} from './components/inventory/import-sheet-create-update/import-sheet-create-update.component';
import {ExportSheetCreateUpdateComponent} from './components/inventory/export-sheet-create-update/export-sheet-create-update.component';
import {InventoryImportSheetService} from "./services/inventory/inventory-import-sheet.service";
import {InventoryExportSheetService} from "./services/inventory/inventory-export-sheet.service";
import { InventorySettingsItemManagementComponent } from './components/inventory/inventory-settings/inventory-settings-item-management/inventory-settings-item-management.component';
import { InventorySettingsItemManagementDetailComponent } from './components/inventory/inventory-settings/inventory-settings-item-management/inventory-settings-item-management-detail/inventory-settings-item-management-detail.component';

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
  declarations: [
    AppComponent,
    IndexComponent,
    LoginComponent,
    FrontDeskComponent,
    TreatmentComponent,
    ProfilesComponent,
    PetsComponent,
    BusinessComponent,
    InventoryComponent,
    AnalysisComponent,
    DataComponent,
    SettingsComponent,
    TestingComponent,
    PharmacyComponent,
    ImagesComponent,
    MembersComponent,
    LogoutComponent,
    EmployeeComponent,
    EmployeeProfileComponent,
    EmployeeLeaveComponent,
    DashboardComponent,
    EmployeeProfileEditComponent,
    EmployeeAdminComponent,
    FinanceComponent,
    RegisterComponent,
    DoctorRegistrationComponent,
    DoctorListViewComponent,
    TimeBasedViewComponent,
    DoctorListItemComponent,
    MyConsultingRoomComponent,
    PetRegistrationComponent,
    PetInfoComponent,
    PetTreatmentComponent,
    InventoryQueryComponent,
    ProcurementManagementComponent,
    ProcurementSettingsComponent,
    VendorManagementComponent,
    VendorCreateUpdateComponent,
    ContactCreateUpdateComponent,
    ProcurementStatusComponent,
    ProcurementRequestComponent,
    ProcurementApprovalComponent,
    ProcurementWorkflowComponent,
    ProcurementRequestCreateUpdateComponent,
    ProcurementRequestDetailComponent,
    RequestGoodComponent,
    ProcurementApprovalListComponent,
    ProcurementApprovalDetailComponent,
    ProcurementTableListViewComponent,
    ProcurementPurchaseComponent,
    ProcurementPurchaseListComponent,
    ProcurementPurchaseCreateUpdateComponent,
    ProcurementPurchaseGoodCreateUpdateComponent,
    ProcurementPurchaseDetailComponent,
    ProcurementRequestDetailTableComponent,
    AuthorizationManagementComponent,
    SecurityOperationPanelComponent,
    VendorProductCategoryComponent,
    CategoryListComponent,
    CategoryDetailComponent,
    EmployeeCreateUpdateComponent,
    EmployeeAdminListComponent,
    EmployeeAdminDetailComponent,
    FactoryResetComponent,
    TreatmentSettingsComponent,
    TreatmentSettingsRoomComponent,
    TreatmentRoomListComponent,
    TreatmentRoomDetailComponent,
    TreatmentRoomEmployeeListComponent,
    TreatmentRoomEmployeeDetailComponent,
    MyConsultingRoomRegistrationListComponent,
    MyConsultingRoomRegistrationDetailComponent,
    MedicalTestSettingsComponent,
    MedicalTestQueryComponent,
    MedicalTestSettingsReportComponent,
    MedicalTestSettingsReportCreateUpdateComponent,
    MedicalTestReportCreateUpdateComponent,
    InpatientComponent,
    EmployeeAdminListOnlyComponent,
    MedicalTestSettingsDepartmentComponent,
    MedicalTestSettingsDepartmentListComponent,
    MedicalTestSettingsDepartmentDetailComponent,
    MedicalTestSettingsDepartmentReportTemplatesComponent,
    PetMedicalTestComponent,
    PetTreatmentDetailComponent,
    RegistrationQueryComponent,
    FeeQueryComponent,
    QueryBarComponent,
    ChargeManagementComponent,
    FinaceQueryComponent,
    ChargeAdminListComponent,
    ChargeAdminDetailComponent,
    MedicalTestSettingsReportTemplateCategoryListComponent,
    MedicalTestSettingsReportTemplateCategoryDetailComponent,
    FieldEditComponent,
    ImportManagementComponent,
    ExportManagementComponent,
    InventorySettingsComponent,
    ImportManagementListComponent,
    ImportManagementDetailComponent,
    InventoryOperationToolBarComponent,
    PriceManagementComponent,
    PriceAdminListComponent,
    MedicalTestReportViewComponent,
    InventorySettingsWarehourseComponent,
    InventoryQueryListComponent,
    InventoryItemCreateUpdateComponent,
    ImportSheetCreateUpdateComponent,
    ExportSheetCreateUpdateComponent,
    InventorySettingsItemManagementComponent,
    InventorySettingsItemManagementDetailComponent,
  ],
  imports: [
    BrowserModule,
    routing,
    HttpModule,
    FormsModule,
    ReactiveFormsModule,
    Ng2Bs3ModalModule,
    TreeModule,
    AngularSplitModule,
    MyDatePickerModule,
    UiSwitchModule,
    NgxPaginationModule
  ],
  providers: [
    {provide: LocationStrategy, useClass: HashLocationStrategy},
    {
      provide: AuthHttp, useFactory: authHttpServiceFactory, deps: [Http, RequestOptions]
    },
    AuthGuard,
    AdminGuard,
    EmployeeManagementGuard,
    ProcurementApprovalGuard,
    VendorGuard,
    LogoutGuardService,
    EmployeeService,
    EmployeeDepartmentService,
    DepartmentService,
    PetOwnerService,
    RegistrationService,
    TreatmentEmployeeService,
    PetService,
    //procurement
    VendorService,
    VendorCategoryService,
    ProcurementService,
    ProcurementStatusService,
    ProcurementRequestService,
    ProcurementApprovalService,
    ProcurementManagementGuard,

    //treatment
    FrontdeskGuard,
    MyConsultingRoomGuard,
    TreatmentSettingsGuard,
    InpatientManagementGuard,
    TreatmentCaseService,

    //finance
    FinanceManagementGuard,
    ChargeManagementGuard,
    PriceManagementGuard,
    FinancePriceService,
    FinanceChargeService,


    //medical test
    MedicalTestReportService,
    MedicalTestReportTemplateService,
    MedicalTestReportTemplateCategoryService,
    MedicalTestManagementGuard,
    MedicalTestDepartmentService,


    //inventory
    InventoryCategoryService,
    InventoryItemService,
    InventoryManagementGuard,

    ProductImportReceiptService,
    InventoryImportSheetService,
    InventoryExportSheetService,

    //medicine
    MedicineManagementGuard,


    //settings
    FactoryResetService,
    AuthenticationService,
    AuthorizationService,

    //common
    TreeNodeService


  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
