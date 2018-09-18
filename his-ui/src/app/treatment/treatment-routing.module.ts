import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {FrontdeskGuard} from "./guards/frontdesk.guard";
import {FrontDeskComponent} from "./components/front-desk/front-desk.component";
import {PetRegistrationComponent} from "./components/front-desk/pet-registration/pet-registration.component";
import {RegistrationQueryComponent} from "./components/front-desk/registration-query/registration-query.component";
import {FeeQueryComponent} from "./components/front-desk/fee-query/fee-query.component";
import {TreatmentComponent} from "./components/treatment.component";
import {RegisterComponent} from "./components/register/register.component";
import {MyConsultingRoomGuard} from "./guards/my-consulting-room.guard";
import {MyConsultingRoomComponent} from "./components/my-consulting-room/my-consulting-room.component";
import {PetInfoComponent} from "./components/my-consulting-room/pet-info/pet-info.component";
import {PetTreatmentComponent} from "./components/my-consulting-room/pet-treatment/pet-treatment.component";
import {PetMedicalTestComponent} from "./components/my-consulting-room/pet-medical-test/pet-medical-test.component";
import {TreatmentSettingsGuard} from "./guards/treatment-settings.guard";
import {TreatmentSettingsComponent} from "./components/treatment-settings/treatment-settings.component";
import {TreatmentSettingsRoomComponent} from "./components/treatment-settings/treatment-settings-room/treatment-settings-room.component";
import {DoctorRegistrationComponent} from "./components/doctor-registration/doctor-registration.component";
import {DoctorListViewComponent} from "./components/doctor-registration/views/doctor-list-view/doctor-list-view.component";
import {TimeBasedViewComponent} from "./components/doctor-registration/views/time-based-view/time-based-view.component";
import {TreatmentCommentsContainerComponent} from "./components/treatment-comments-container/treatment-comments-container.component";

const routes: Routes = [
  {
    path: '',
    component: TreatmentComponent
  },
  {

    path: 'frontdesk',
    canActivate: [FrontdeskGuard],
    component: FrontDeskComponent,
    children: [
      {
        path: 'petreg',
        component: PetRegistrationComponent
      },
      {
        path: 'registration-query',
        component: RegistrationQueryComponent
      },
      {

        path: 'fee-query',
        component: FeeQueryComponent,
      },
      {
        path: '**',
        redirectTo: 'petreg',
      }
    ]
  },
  {
    path: 'customer-service',
    component: TreatmentCommentsContainerComponent,
  },
  {
    //看病挂号,暂时不用
    path: 'register',
    component: RegisterComponent
  },
  {
    path: 'my-consulting-room',
    canActivate: [MyConsultingRoomGuard],
    component: MyConsultingRoomComponent,
    children: [
      {
        path: 'pet-info',
        component: PetInfoComponent,
      },
      {
        path: 'pet-treatment',
        component: PetTreatmentComponent,
      },
      {
        path: 'pet-medical-test',
        component: PetMedicalTestComponent,

      },
      {
        path: '**',
        redirectTo: 'pet-info'
      }
    ]
  },
  {
    path: 'treatment-settings',
    canActivate: [TreatmentSettingsGuard],
    component: TreatmentSettingsComponent,

    children: [
      {
        path: 'treatment-room',
        component: TreatmentSettingsRoomComponent
      },

    ]
  },
  {
    path: 'doctor-registration',
    component: DoctorRegistrationComponent,
    children: [
      {
        path: 'doctor-list-view/:uuid',
        component: DoctorListViewComponent,
      },
      {
        path: 'time-based-view/:uuid',
        component: TimeBasedViewComponent,
      },
      {
        path: '**',
        redirectTo: 'doctor-list-view',
      }
    ]
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class TreatmentRoutingModule {
}
