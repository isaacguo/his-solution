import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EmployeeRoutingModule } from './employee-routing.module';
import {EmployeeComponent} from "./components/employee.component";

@NgModule({
  imports: [
    CommonModule,
    EmployeeRoutingModule,

    EmployeeComponent,
  ],
  declarations: []
})
export class EmployeeModule { }
