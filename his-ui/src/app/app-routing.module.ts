import {NgModule} from '@angular/core';
import {PreloadAllModules, RouterModule, Routes} from '@angular/router';
import {IndexComponent} from "./core/components/index/index.component";
import {LoginComponent} from "./auth/components/login/login.component";
import {LogoutComponent} from "./auth/components/logout/logout.component";
import {AuthGuard, LogoutGuardService} from "./auth/guards/auth.guard";

const routes: Routes = [
  {
    path: '',
    component: IndexComponent,
    canActivate: [AuthGuard],
    children: [
      {
        path: 'dashboard',
        loadChildren: './dashboard/dashboard.module#DashboardModule'
      },
      {
        path: 'treatment',
        loadChildren: './treatment/treatment.module#TreatmentModule'
      },
      {
        path: 'medical-test',
        loadChildren: './medical-test/medical-test.module#MedicalTestModule'
      },
      {
        path: 'finance',
        loadChildren: './finance/finance.module#FinanceModule'
      },
      {
        path: 'pharmacy',
        loadChildren: './pharmacy/pharmacy.module#PharmacyModule'
      },
      {
        path: 'employee',
        loadChildren: './employee/employee.module#EmployeeModule'
      },
      {
        path: 'procurement',
        loadChildren: './procurement/procurement.module#ProcurementModule'
      },
      {
        path: 'inventory',
        loadChildren: './inventory/inventory.module#InventoryModule'
      },
      {
        path: 'settings',
        loadChildren: './settings/settings.module#SettingsModule'
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
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {preloadingStrategy: PreloadAllModules})],
  exports: [RouterModule]
})

export class AppRoutingModule {
}
