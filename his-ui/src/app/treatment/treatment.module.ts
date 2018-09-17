import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { TreatmentRoutingModule } from './treatment-routing.module';
import {FrontDeskComponent} from "./front-desk/front-desk.component";

@NgModule({
  imports: [
    CommonModule,
    TreatmentRoutingModule
  ],
  declarations: [
    FrontDeskComponent
  ]
})
export class TreatmentModule { }
