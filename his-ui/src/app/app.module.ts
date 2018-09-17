import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppComponent} from "./app.component";
import {CoreModule} from "./core/core.module";
import {SharedModule} from "./shared/shared.module";
import {AuthModule} from "./auth/auth.module";
import {AppRoutingModule} from "./app-routing.module";
import {DashboardModule} from "./dashboard/dashboard.module";
import {TreatmentModule} from "./treatment/treatment.module";
import {MedicalTestModule} from "./medical-test/medical-test.module";
import {FinanceModule} from "./finance/finance.module";
import {PharmacyModule} from "./pharmacy/pharmacy.module";
import {EmployeeModule} from "./employee/employee.module";
import {ProcurementModule} from "./procurement/procurement.module";
import {InventoryModule} from "./inventory/inventory.module";
import {IndexComponent} from "./core/components/index/index.component";


/*
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
*/

@NgModule({
  declarations: [
    AppComponent,
    IndexComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,

    CoreModule,
    SharedModule,

    AuthModule,

    //feature modules
    DashboardModule,
    TreatmentModule,
    MedicalTestModule,
    FinanceModule,
    PharmacyModule,
    EmployeeModule,
    ProcurementModule,
    InventoryModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
