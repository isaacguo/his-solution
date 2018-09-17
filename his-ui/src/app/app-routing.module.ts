import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {IndexComponent} from "./core/components/index/index.component";

const routes: Routes = [
  {
    path: '',
    component: IndexComponent,
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
      }
    ]
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
