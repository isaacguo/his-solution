import {NgModule} from '@angular/core';
import {PreloadAllModules, RouterModule, Routes} from '@angular/router';
import {IndexContainerComponent} from "./core/containers/index-container/index-container.component";
import {AuthGuard} from "./auth/guards/auth.guard";
import {GuardFactoryService} from "./core/services/guard-factory.service";

const routes: Routes = [
  {
    path: '',
    component: IndexContainerComponent,
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
  }
];

let routeGuardFactory = (key: string, guardFactoryService: GuardFactoryService) => {
  //return guardFactoryService.getGuard(domain + '-' + topic + '-' + action);
  return guardFactoryService.getGuard(key);
}

@NgModule({
  imports: [RouterModule.forRoot(routes, {
    // preload all modules; optionally we could
    // implement a custom preloading strategy for just some
    // of the modules (PRs welcome 😉)
    preloadingStrategy: PreloadAllModules
  })],
  providers: [

    /*
    {
      provide: 'canTreatment',
      useFactory: routeGuardFactory,
      deps: ['Treatment-前台服务-操作', GuardFactoryService]
    }
    */
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
