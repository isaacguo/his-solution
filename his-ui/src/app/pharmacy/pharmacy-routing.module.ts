import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {PharmacyMedicineDispensingManagementComponent} from "./components/pharmacy-medicine-dispensing-management/pharmacy-medicine-dispensing-management.component";

const routes: Routes = [
  {
    path: 'pharmacy-dispensing-management',
    component:PharmacyMedicineDispensingManagementComponent
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PharmacyRoutingModule { }
