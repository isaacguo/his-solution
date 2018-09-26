import {NgModule} from '@angular/core';

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
import {PetRegistrationComponent} from "./components/front-desk/pet-registration/pet-registration.component";
import {RegistrationQueryComponent} from "./components/front-desk/registration-query/registration-query.component";
import {MyConsultingRoomRegistrationDetailComponent} from "./components/my-consulting-room/my-consulting-room-registration-list/my-consulting-room-registration-detail/my-consulting-room-registration-detail.component";
import {MyConsultingRoomRegistrationListComponent} from "./components/my-consulting-room/my-consulting-room-registration-list/my-consulting-room-registration-list.component";
import {DoctorListViewComponent} from "./components/doctor-registration/views/doctor-list-view/doctor-list-view.component";
import {DoctorListItemComponent} from "./components/doctor-registration/views/doctor-list-view/doctor-list-item/doctor-list-item.component";
import {FeeQueryComponent} from "./components/front-desk/fee-query/fee-query.component";
import {PetTreatmentComponent} from "./components/my-consulting-room/pet-treatment/pet-treatment.component";
import {PetMedicalTestComponent} from "./components/my-consulting-room/pet-medical-test/pet-medical-test.component";
import {PetInfoComponent} from "./components/my-consulting-room/pet-info/pet-info.component";
import {MyConsultingRoomComponent} from "./components/my-consulting-room/my-consulting-room.component";
import {DoctorRegistrationComponent} from "./components/doctor-registration/doctor-registration.component";
import {TimeBasedViewComponent} from "./components/doctor-registration/views/time-based-view/time-based-view.component";
import {FromNowPipe} from "./pipes/from-now.pipe";
import {PetTreatmentDetailComponent} from "./components/my-consulting-room/pet-treatment/pet-treatment-detail/pet-treatment-detail.component";
import {SharedModule} from "../shared/shared.module";
import {EmployeeProfilePictureComponent} from "./components/employee-profile-picture/employee-profile-picture.component";
import {CustomerServiceContainerComponent} from './containers/customer-service-container/customer-service-container.component';
import {CustomerServiceTreatmentCaseContainerComponent} from './containers/customer-service-treatment-case-container/customer-service-treatment-case-container.component';
import {QueryResultTableComponent} from './components/query-result-table/query-result-table.component';
import {CustomerServiceTreatmentCaseInfoContainerComponent} from './containers/customer-service-treatment-case-info-container/customer-service-treatment-case-info-container.component';
import {CustomerServiceTreatmentCaseDetailContainerComponent} from './containers/customer-service-treatment-case-detail-container/customer-service-treatment-case-detail-container.component';
import {CustomerServiceTreatmentCaseCommentsContainerComponent} from './containers/customer-service-treatment-case-comments-container/customer-service-treatment-case-comments-container.component';
import {CustomerServicePetInfoComponent} from './components/customer-service/customer-service-pet-info/customer-service-pet-info.component';
import {CustomerServiceTreatmentDetailComponent} from './components/customer-service/customer-service-treatment-detail/customer-service-treatment-detail.component';
import {CustomerServiceCommentsComponent} from './components/customer-service/customer-service-comments/customer-service-comments.component';
import {CustomerServiceCommentComponent} from './components/customer-service/customer-service-comment/customer-service-comment.component';
import {TreatmentSettingsBusinessContainerComponent} from './containers/treatment-settings-business-container/treatment-settings-business-container.component';
import { TreatmentItemCreateUpdateComponent } from './components/treatment-item-create-update/treatment-item-create-update.component';


@NgModule({
  imports: [
    SharedModule,
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
    PetRegistrationComponent,
    RegistrationQueryComponent,
    MyConsultingRoomComponent,
    MyConsultingRoomRegistrationDetailComponent,
    MyConsultingRoomRegistrationListComponent,
    DoctorListViewComponent,
    DoctorListItemComponent,
    FeeQueryComponent,
    MyConsultingRoomComponent,
    PetInfoComponent,
    PetTreatmentComponent,
    PetMedicalTestComponent,
    DoctorRegistrationComponent,
    TimeBasedViewComponent,
    FromNowPipe,
    PetTreatmentDetailComponent,
    EmployeeProfilePictureComponent,
    CustomerServiceContainerComponent,
    CustomerServiceTreatmentCaseContainerComponent,
    QueryResultTableComponent,
    CustomerServiceTreatmentCaseInfoContainerComponent,
    CustomerServiceTreatmentCaseDetailContainerComponent,
    CustomerServiceTreatmentCaseCommentsContainerComponent,
    CustomerServicePetInfoComponent,
    CustomerServiceTreatmentDetailComponent,
    CustomerServiceCommentsComponent,
    CustomerServiceCommentComponent,
    TreatmentSettingsBusinessContainerComponent,
    TreatmentItemCreateUpdateComponent,
  ]
})
export class TreatmentModule {
}
