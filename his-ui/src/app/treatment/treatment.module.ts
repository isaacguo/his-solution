import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {TreatmentRoutingModule} from './treatment-routing.module';
import {FrontDeskComponent} from "./components/front-desk/front-desk.component";
import {TreatmentComponent} from "./components/treatment.component";
import {TreatmentSettingsComponent} from "./components/treatment-settings/treatment-settings.component";
import {TreatmentSettingsRoomComponent} from "./components/treatment-settings/treatment-settings-room/treatment-settings-room.component";
import {TreatmentRoomListComponent} from "./components/treatment-settings/treatment-settings-room/treatment-room-list/treatment-room-list.component";
import {TreatmentRoomDetailComponent} from "./components/treatment-settings/treatment-settings-room/treatment-room-detail/treatment-room-detail.component";
import {TreatmentRoomEmployeeListComponent} from "./components/treatment-settings/treatment-settings-room/treatment-room-detail/treatment-room-employee-list/treatment-room-employee-list.component";
import {TreatmentRoomEmployeeDetailComponent} from "./components/treatment-settings/treatment-settings-room/treatment-room-detail/treatment-room-employee-list/treatment-room-employee-detail/treatment-room-employee-detail.component";
import {RegisterComponent} from "./components/register/register.component";
import {FrontdeskGuard} from "./guards/frontdesk.guard";
import {InpatientManagementGuard} from "./guards/inpatient-management.guard";
import {MyConsultingRoomGuard} from "./guards/my-consulting-room.guard";
import {TreatmentSettingsGuard} from "./guards/treatment-settings.guard";
import {CustomerComponent} from "./components/customer.component";
import {TreatmentCommentsContainerComponent} from "./components/treatment-comments-container/treatment-comments-container.component";

@NgModule({
  imports: [
    CommonModule,
    TreatmentRoutingModule
  ],
  declarations: [
    FrontDeskComponent,
    TreatmentComponent,
    TreatmentSettingsComponent,
    TreatmentSettingsRoomComponent,
    TreatmentRoomListComponent,
    TreatmentRoomDetailComponent,
    TreatmentRoomEmployeeListComponent,
    TreatmentRoomEmployeeDetailComponent,
    RegisterComponent,
    CustomerComponent,
    TreatmentCommentsContainerComponent,



  ],
  providers:[
    FrontdeskGuard,
    InpatientManagementGuard,
    MyConsultingRoomGuard,
    TreatmentSettingsGuard
  ]
})
export class TreatmentModule { }
