import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PharmacyRoutingModule } from './pharmacy-routing.module';
import {PharmacyComponent} from "./components/pharmacy.component";
import {PharmacyMedicineDispensingManagementComponent} from "./components/pharmacy-medicine-dispensing-management/pharmacy-medicine-dispensing-management.component";
import {PharmacyMedicineDispensingManagementListComponent} from "./components/pharmacy-medicine-dispensing-management/pharmacy-medicine-dispensing-management-list/pharmacy-medicine-dispensing-management-list.component";
import {PharmacyManagementGuard} from "./guards/pharmacy-management-guard.service";

@NgModule({
  imports: [
    CommonModule,
    PharmacyRoutingModule
  ],
  declarations: [
    PharmacyComponent,
    PharmacyMedicineDispensingManagementComponent,
    PharmacyMedicineDispensingManagementListComponent
  ],
  providers:[
    PharmacyManagementGuard
  ]
})
export class PharmacyModule { }
