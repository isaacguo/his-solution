import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {IndexComponent} from './components/index/index.component';
import {LoginComponent} from './components/login/login.component';
import {routing} from "../app.routing";
import {Http, HttpModule, RequestOptions} from "@angular/http";
import {FormsModule} from "@angular/forms";
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
import {ProcurementComponent} from './components/procurement/procurement.component';
import {ImagesComponent} from './components/images/images.component';
import {MembersComponent} from './components/members/members.component';
import {LogoutComponent} from './components/logout/logout.component';
import {AuthConfig, AuthHttp} from "angular2-jwt";
import {AuthGuard, LogoutGuardService} from "./guards/auth.guard";
import {AuthenticationService} from "./services/common/authentication.service";
import {EmployeeComponent} from './components/employee/employee.component';
import {EmployeeService} from "./services/business/employee/employee.service";
import {EmployeeProfileComponent} from './components/employee/employee-profile/employee-profile.component';
import {EmployeeLeaveComponent} from './components/employee/employee-leave/employee-leave.component';
import {DashboardComponent} from './components/dashboard/dashboard.component';
import {EmployeeProfileEditComponent} from './components/employee/employee-profile-edit/employee-profile-edit.component';
import {EmployeeAdminComponent} from './components/employee/employee-admin/employee-admin.component';
import {AdminGuard} from "./guards/admin.guard";
import {FinanceComponent} from './components/finance/finance.component';
import {FinanceGuard} from "./guards/finance.guard";
import {RegisterComponent} from './components/treatment/register/register.component';
import {DoctorRegistrationComponent} from './components/treatment/doctor-registration/doctor-registration.component';
import {DoctorListViewComponent} from './components/treatment/doctor-registration/views/doctor-list-view/doctor-list-view.component';
import {TimeBasedViewComponent} from './components/treatment/doctor-registration/views/time-based-view/time-based-view.component';
import {DoctorListItemComponent} from './components/treatment/doctor-registration/views/doctor-list-view/doctor-list-item/doctor-list-item.component';
import {MyConsultingRoomComponent} from './components/treatment/my-consulting-room/my-consulting-room.component';
import {CallNextComponent} from './components/treatment/my-consulting-room/call-next/call-next.component';
import {PatientTreatmentComponent} from './components/treatment/my-consulting-room/patient-treatment/patient-treatment.component';
import {DepartmentService} from "./services/treatment/department.service";
import {Ng2Bs3ModalModule} from "ng2-bs3-modal/ng2-bs3-modal";
import {FrontDeskComponent} from "./components/treatment/front-desk/front-desk.component";
import { PetRegistrationComponent } from './components/treatment/front-desk/pet-registration/pet-registration.component';
import {PetOwnerService} from "./services/treatment/pet-owner.service";

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
    ProcurementComponent,
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
    CallNextComponent,
    PatientTreatmentComponent,
    PetRegistrationComponent
  ],
  imports: [
    BrowserModule, routing, HttpModule, FormsModule, Ng2Bs3ModalModule
  ],
  providers: [
    {provide: LocationStrategy, useClass: HashLocationStrategy},
    {
      provide: AuthHttp, useFactory: authHttpServiceFactory, deps: [Http, RequestOptions]
    },
    AuthGuard,
    AdminGuard,
    FinanceGuard,
    LogoutGuardService,
    AuthenticationService,
    EmployeeService,
    DepartmentService,
    PetOwnerService,
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
