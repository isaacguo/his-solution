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
import {ProcurementComponent} from "./app/components/procurement/procurement.component";
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
import {CallNextComponent} from "./app/components/treatment/my-consulting-room/call-next/call-next.component";
import {PatientTreatmentComponent} from "./app/components/treatment/my-consulting-room/patient-treatment/patient-treatment.component";
import {FrontDeskComponent} from "./app/components/treatment/front-desk/front-desk.component";
import {PetRegistrationComponent} from "./app/components/treatment/front-desk/pet-registration/pet-registration.component";


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
        children:[
          {
            path: 'petreg',
            component: PetRegistrationComponent
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
        canActivate: [AdminGuard],
        component: EmployeeAdminComponent
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
        component: ProcurementComponent
      },
      {
        path: 'inventory',
        component: InventoryComponent
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
        component: SettingsComponent
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
  },

  // otherwise redirect to home
  {path: '**', redirectTo: 'login'}

]


export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);
