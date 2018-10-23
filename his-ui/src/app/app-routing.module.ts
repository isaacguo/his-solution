import {NgModule} from '@angular/core';
import {Routes, RouterModule, PreloadAllModules} from '@angular/router';
import {IndexContainerComponent} from "./core/containers/index-container/index-container.component";
import {LoginComponent} from "./auth/components/login/login.component";
import {LogoutComponent} from "./auth/components/logout/logout.component";

const routes: Routes = [
  {
    path: '',
    component: IndexContainerComponent,
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
        path: 'procurement',
        loadChildren: './procurement/procurement.module#ProcurementModule'
      },
      {
        path: 'employee',
        loadChildren: './employee/employee.module#EmployeeModule'
      },
      {
        path: 'inventory',
        loadChildren: './inventory/inventory.module#InventoryModule'
      },
      {
        path: 'statistics',
        loadChildren: './statistics/statistics.module#StatisticsModule'
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
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {
    // preload all modules; optionally we could
    // implement a custom preloading strategy for just some
    // of the modules (PRs welcome 😉)
    preloadingStrategy: PreloadAllModules
  })],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
