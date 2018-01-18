import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {IndexComponent} from './components/index/index.component';
import {LoginComponent} from './components/login/login.component';
import {routing} from "../app.routing";
import {Http, HttpModule, RequestOptions} from "@angular/http";
import {FormsModule} from "@angular/forms";
import {HashLocationStrategy, LocationStrategy} from "@angular/common";
import {FrontDeskComponent} from './components/front-desk/front-desk.component';
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
import { MembersComponent } from './components/members/members.component';
import { LogoutComponent } from './components/logout/logout.component';
import {AuthConfig, AuthHttp} from "angular2-jwt";
import {AuthGuard, LogoutGuardService} from "./guards/auth.guard";
import {AuthenticationService} from "./services/common/authentication.service";
import { EmployeeComponent } from './components/employee/employee.component';
import {EmployeeService} from "./services/business/employee/employee.service";

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
    EmployeeComponent
  ],
  imports: [
    BrowserModule, routing, HttpModule, FormsModule
  ],
  providers: [
    {provide: LocationStrategy, useClass: HashLocationStrategy},
    {
      provide: AuthHttp, useFactory: authHttpServiceFactory, deps: [Http, RequestOptions]
    },
    AuthGuard,
    LogoutGuardService,
    AuthenticationService,
    EmployeeService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
