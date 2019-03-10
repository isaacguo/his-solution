import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {TreatmentContainerComponent} from "./containers/treatment-container/treatment-container.component";
import {FinanceContainerComponent} from "./containers/finance-container/finance-container.component";
import {MedicalTestContainerComponent} from "./containers/medical-test-container/medical-test-container.component";
import {MedicineContainerComponent} from "./containers/medicine-container/medicine-container.component";
import {ProcurementContainerComponent} from "./containers/procurement-container/procurement-container.component";

const routes: Routes = [
  {
    path:'treatment',
    component:TreatmentContainerComponent
  },
  {
    path:'finance',
    component:FinanceContainerComponent
  },
  {
    path:'medical-test',
    component:MedicalTestContainerComponent,
  },
  {
    path:'procurement',
    component:ProcurementContainerComponent
  },
  {
    path:'medicine',
    component:MedicineContainerComponent
  },


];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class StatisticsRoutingModule { }
