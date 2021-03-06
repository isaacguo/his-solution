import {RouterModule, Routes} from "@angular/router";
import {ModuleWithProviders} from "@angular/core";
import {IndexComponent} from "./app/components/index/index.component";
import {LoginComponent} from "./app/components/login/login.component";
import {TreatmentComponent} from "./app/components/treatment/treatment.component";
import {TestingComponent} from "./app/components/testing/testing.component";
import {ImagesComponent} from "./app/components/images/images.component";
import {PharmacyComponent} from "./app/components/pharmacy/pharmacy.component";
import {ProfilesComponent} from "./app/components/profiles/profiles.component";
import {MembersComponent} from "./app/components/members/members.component";
import {PetsComponent} from "./app/components/pets/pets.component";
import {BusinessComponent} from "./app/components/business/business.component";
import {InventoryComponent} from "./app/components/inventory/inventory.component";
import {AnalysisComponent} from "./app/components/analysis/analysis.component";
import {DataComponent} from "./app/components/data/data.component";
import {SettingsComponent} from "./app/components/settings/settings.component";
import {AuthGuard, LogoutGuardService} from "./app/guards/auth.guard";
import {LogoutComponent} from "./app/components/logout/logout.component";
import {EmployeeComponent} from "./app/components/employee/employee.component";
import {EmployeeLeaveComponent} from "./app/components/employee/employee-leave/employee-leave.component";
import {EmployeeProfileComponent} from "./app/components/employee/employee-profile/employee-profile.component";
import {DashboardComponent} from "./app/components/dashboard/dashboard.component";
import {EmployeeProfileEditComponent} from "./app/components/employee/employee-profile-edit/employee-profile-edit.component";
import {EmployeeAdminComponent} from "./app/components/employee/employee-admin/employee-admin.component";
import {AdminGuard} from "./app/guards/admin.guard";
import {FinanceComponent} from "./app/components/finance/finance.component";
import {FinanceGuard} from "./app/guards/finance.guard";
import {RegisterComponent} from "./app/components/treatment/register/register.component";
import {DoctorRegistrationComponent} from "./app/components/treatment/doctor-registration/doctor-registration.component";
import {DoctorListViewComponent} from "./app/components/treatment/doctor-registration/views/doctor-list-view/doctor-list-view.component";
import {TimeBasedViewComponent} from "./app/components/treatment/doctor-registration/views/time-based-view/time-based-view.component";
import {MyConsultingRoomComponent} from "./app/components/treatment/my-consulting-room/my-consulting-room.component";
import {FrontDeskComponent} from "./app/components/treatment/front-desk/front-desk.component";
import {PetRegistrationComponent} from "./app/components/treatment/front-desk/pet-registration/pet-registration.component";
import {PetInfoComponent} from "./app/components/treatment/my-consulting-room/pet-info/pet-info.component";
import {PetTreatmentComponent} from "./app/components/treatment/my-consulting-room/pet-treatment/pet-treatment.component";
import {InventoryQueryComponent} from "./app/components/inventory/inventory-query/inventory-query.component";
import {ProcurementManagementComponent} from "./app/components/procurement/procurement-management/procurement-management.component";
import {ProcurementSettingsComponent} from "./app/components/procurement/procurement-settings/procurement-settings.component";
import {VendorManagementComponent} from "./app/components/procurement/procurement-settings/vendor-management/vendor-management.component";
import {VendorCreateUpdateComponent} from "./app/components/procurement/procurement-settings/vendor-create-update/vendor-create-update.component";
import {ProcurementStatusComponent} from "./app/components/procurement/procurement-settings/procurement-status/procurement-status.component";
import {ProcurementApprovalComponent} from "./app/components/procurement/procurement-approval/procurement-approval.component";
import {ProcurementWorkflowComponent} from "./app/components/procurement/procurement-settings/procurement-workflow/procurement-workflow.component";
import {ProcurementRequestCreateUpdateComponent} from "./app/components/procurement/procurement-request/procurement-request-create-update/procurement-request-create-update.component";
import {ProcurementApprovalListComponent} from "./app/components/procurement/procurement-approval/procurement-approval-list/procurement-approval-list.component";
import {ProcurementPurchaseComponent} from "./app/components/procurement/procurement-purchase/procurement-purchase.component";
import {ProcurementPurchaseListComponent} from "./app/components/procurement/procurement-purchase/procurement-purchase-list/procurement-purchase-list.component";
import {AuthorizationManagementComponent} from "./app/components/settings/authorization-management/authorization-management.component";
import {ProcurementApprovalGuard} from "./app/guards/procurement-approval.guard";
import {VendorProductCategoryComponent} from "./app/components/procurement/procurement-settings/vendor-product-category/vendor-product-category.component";
import {EmployeeManagementGuard} from "./app/guards/employee-management.guard";
import {VendorGuard} from "./app/guards/procurement/vendor.guard";
import {EmployeeCreateUpdateComponent} from "./app/components/employee/employee-create-update/employee-create-update.component";


const appRoutes: Routes = [
  {
    path: '',
    component: IndexComponent,
    canActivate: [AuthGuard],
    children: [
      {
        path: 'dashboard',
        component: DashboardComponent
      },
      {
        path: 'frontdesk',
        component: FrontDeskComponent,
        children: [
          {
            path: 'petreg',
            component: PetRegistrationComponent
          },
          {
            path: '**',
            redirectTo: 'petreg',
          }
        ]
      },
      {
        path: 'treatment',
        component: TreatmentComponent
      },
      {
        path: 'register',
        component: RegisterComponent
      },
      {
        path: 'my-consulting-room',
        component: MyConsultingRoomComponent,
        children: [
          {
            path: 'pet-info',
            component: PetInfoComponent,
          },
          {
            path: 'pet-treatment',
            component: PetTreatmentComponent,
          },
          {
            path: '**',
            redirectTo: 'pet-info'
          }
        ]
      },
      {
        path: 'doctor-registration',
        component: DoctorRegistrationComponent,
        children: [
          {
            path: 'doctor-list-view/:uuid',
            component: DoctorListViewComponent,
          },
          {
            path: 'time-based-view/:uuid',
            component: TimeBasedViewComponent,
          },
          {
            path: '**',
            redirectTo: 'doctor-list-view',

          }
        ]
      },
      {
        path: 'testing',
        component: TestingComponent
      },
      {
        path: 'images',
        component: ImagesComponent
      },
      {
        path: 'finance',
        canActivate: [FinanceGuard],
        component: FinanceComponent
      },
      {
        path: 'pharmacy',
        component: PharmacyComponent
      },
      {
        path: 'profiles',
        component: ProfilesComponent
      },
      {
        path: 'employee-profile',
        component: EmployeeProfileComponent,
      },
      {
        path: 'employee-profile/:uuid', component: EmployeeProfileComponent
      },
      {
        path: 'employee-profile-edit',
        component: EmployeeProfileEditComponent
      },
      {
        path: 'employee-profile-edit/:uuid', component: EmployeeProfileEditComponent
      },
      {
        path: 'employee-leave',
        component: EmployeeLeaveComponent
      },
      {
        path: 'employee-admin',
        canActivate: [EmployeeManagementGuard],
        component: EmployeeAdminComponent
      },
      {
        path: 'employee-operation/:operation/:updateId',
        component: EmployeeCreateUpdateComponent
      },
      {
        path: 'employee',
        component: EmployeeComponent,
        children: []
      },
      {
        path: 'members',
        component: MembersComponent
      },
      {
        path: 'pets',
        component: PetsComponent
      },
      {
        path: 'business',
        component: BusinessComponent
      },
      {
        path: 'procurement',
        component: ProcurementManagementComponent
      },
      {
        path: 'procurement-approval',
        component: ProcurementApprovalComponent,
        canActivate: [ProcurementApprovalGuard],
        children: [
          {
            path: 'list',
            component: ProcurementApprovalListComponent,
          },
          {
            path: '**',
            redirectTo: 'list',
          }
        ]
      },
      {
        path:'procurement-purchase',
        component:ProcurementPurchaseComponent,
        children:[
          {
            path:'list',
            component:ProcurementPurchaseListComponent
          },
          {
            path: ':operation',
            component: ProcurementRequestCreateUpdateComponent,
          },
          /*
          {
            path:':operation',
            component:ProcurementPurchaseCreateUpdateComponent
          },
          {
            path: ':operation/:updateId',
            component: ProcurementPurchaseCreateUpdateComponent,
          },
          */
          {
            path:'**',
            redirectTo:'list'
          }
        ]
      },
      {
        path: 'procurement-settings',
        component: ProcurementSettingsComponent,
        children: [
          {
            path: 'vendors/:operation',
            component: VendorCreateUpdateComponent
          },
          {
            path: 'vendors/:operation/:updateId',
            component: VendorCreateUpdateComponent
          },
          {
            path:'vendors',
            component:VendorProductCategoryComponent,
            canActivate: [VendorGuard],

          },
          {
            path: 'procurement-status',
            component: ProcurementStatusComponent
          },
          {
            path: 'procurement-workflow',
            component: ProcurementWorkflowComponent
          }
        ]
      },
      {
        path: 'inventory',
        component: InventoryComponent
      },
      {
        path: 'inventory-query',
        component: InventoryQueryComponent

      },
      {
        path: 'analysis',
        component: AnalysisComponent
      },
      {
        path: 'data',
        component: DataComponent
      },
      {
        path: 'settings',
        component: SettingsComponent,
      },
      {
        path: 'settings-authorization',
        canActivate: [AdminGuard],
        component: AuthorizationManagementComponent
      }
    ]
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'logout',
    component: LogoutComponent,
    canActivate: [LogoutGuardService]
  }

  // otherwise redirect to home
  //{path: '**', redirectTo: 'login'}

]


export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);
