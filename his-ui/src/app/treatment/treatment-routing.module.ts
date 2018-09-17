import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {FrontDeskComponent} from "./front-desk/front-desk.component";

const routes: Routes = [
  {
    path: 'frontdesk',
    component: FrontDeskComponent,


  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class TreatmentRoutingModule { }
