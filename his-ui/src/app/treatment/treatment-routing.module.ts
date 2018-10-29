import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {FrontDeskContainerComponent} from "./containers/front-desk-container/front-desk-container.component";
import {PetRegistrationContainerComponent} from "./containers/pet-registration-container/pet-registration-container.component";
import {RegistrationQueryContainerComponent} from "./containers/registration-query-container/registration-query-container.component";
import {FeeQueryContainerComponent} from "./containers/fee-query-container/fee-query-container.component";
import {CustomerServiceContainerComponent} from "./containers/customer-service-container/customer-service-container.component";
import {CustomerServiceTreatmentCaseContainerComponent} from "./containers/customer-service-treatment-case-container/customer-service-treatment-case-container.component";
import {CustomerServiceTreatmentCaseInfoContainerComponent} from "./containers/customer-service-treatment-case-info-container/customer-service-treatment-case-info-container.component";
import {CustomerServiceTreatmentCaseDetailContainerComponent} from "./containers/customer-service-treatment-case-detail-container/customer-service-treatment-case-detail-container.component";
import {CustomerServiceTreatmentCaseCommentsContainerComponent} from "./containers/customer-service-treatment-case-comments-container/customer-service-treatment-case-comments-container.component";
import {MyConsultingRoomContainerComponent} from "./containers/my-consulting-room-container/my-consulting-room-container.component";
import {PetInfoContainerComponent} from "./containers/pet-info-container/pet-info-container.component";
import {PetTreatmentContainerComponent} from "./containers/pet-treatment-container/pet-treatment-container.component";
import {TreatmentSettingsContainerComponent} from "./containers/treatment-settings-container/treatment-settings-container.component";
import {TreatmentSettingsRoomContainerComponent} from "./containers/treatment-settings-room-container/treatment-settings-room-container.component";
import {TreatmentSettingsBusinessContainerComponent} from "./containers/treatment-settings-business-container/treatment-settings-business-container.component";
import {MyConsultingRoomRegistrationContainerComponent} from "./containers/my-consulting-room-registration-container/my-consulting-room-registration-container.component";
import {TreatmentPrescriptionsContainerComponent} from './containers/treatment-prescriptions-container/treatment-prescriptions-container.component';
import {TreatmentCaseDetailContainerComponent} from "./containers/treatment-case-detail-container/treatment-case-detail-container.component";
import {TreatmentMedicalTestContainerComponent} from "./containers/treatment-medical-test-container/treatment-medical-test-container.component";
import {TreatmentPrescriptionDetailContainerComponent} from './containers/treatment-prescription-detail-container/treatment-prescription-detail-container.component';
import {TreatmentSettingsRoomDetailContainerComponent} from "./containers/treatment-settings-room-detail-container/treatment-settings-room-detail-container.component";

const routes: Routes = [
  {
    path: 'frontdesk',
    component: FrontDeskContainerComponent,

    children: [
      {
        path: 'petreg',
        component: PetRegistrationContainerComponent
      },
      {
        path: 'registration-query',
        component: RegistrationQueryContainerComponent,
      },
      {

        path: 'fee-query',
        component: FeeQueryContainerComponent,
      },
      {
        path: '**',
        redirectTo: 'petreg',
      }
    ]
  },
  {
    path: 'customer-service',
    component: CustomerServiceContainerComponent,
    children: [
      {
        path: 'treatment-case/:treatmentCaseId',
        component: CustomerServiceTreatmentCaseContainerComponent,
        children: [
          {
            path: 'info',
            component: CustomerServiceTreatmentCaseInfoContainerComponent,
          },
          {
            path: 'detail',
            component: CustomerServiceTreatmentCaseDetailContainerComponent,
          },
          {
            path: 'comments',
            component: CustomerServiceTreatmentCaseCommentsContainerComponent
          },
          {
            path: '**',
            redirectTo: 'info'
          }
        ]
      },
    ],
  },
  {
    path: 'my-consulting-room',
    component: MyConsultingRoomContainerComponent,
    children: [
      {
        path: 'registrations/:registrationId',
        component: MyConsultingRoomRegistrationContainerComponent,
        children: [
          {
            path: 'info',
            component: PetInfoContainerComponent,
          },
          {
            path: 'treatment-cases',
            component: PetTreatmentContainerComponent,
            children:[
              {
                path:':treatmentCaseId',
                component: TreatmentCaseDetailContainerComponent
              }
            ]
          },
          {
            path:'medical-tests',
            component:TreatmentMedicalTestContainerComponent,
            children:[
              {
                path:':medicalTestId',
                component: TreatmentCaseDetailContainerComponent,
              }
            ]
          },
          {
            path:'treatment-prescriptions',
            component:TreatmentPrescriptionsContainerComponent,
            children:[
              {
                path:':prescriptionId',
                component:TreatmentPrescriptionDetailContainerComponent
              }
            ]
          },
          {
            path: '**',
            redirectTo: 'info'
          }
        ]
      }
    ]
  },
  {
    path: 'treatment-settings',
    component: TreatmentSettingsContainerComponent,
    children: [
      {
        path: 'treatment-room',
        component: TreatmentSettingsRoomContainerComponent,
        children:
        [
          {
            path:':departmentId',
            component:TreatmentSettingsRoomDetailContainerComponent
          }
        ]

      },
      {
        path: 'business',
        component: TreatmentSettingsBusinessContainerComponent
      },
      {
        path:'**',
        redirectTo:'treatment-room'
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