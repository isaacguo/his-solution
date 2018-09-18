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
import {FrontdeskGuard} from "./guards/frontdesk.guard";
import {InpatientManagementGuard} from "./guards/inpatient-management.guard";
import {MyConsultingRoomGuard} from "./guards/my-consulting-room.guard";
import {TreatmentSettingsGuard} from "./guards/treatment-settings.guard";
import {CustomerComponent} from "./components/customer.component";
import {TreatmentCommentsContainerComponent} from "./components/treatment-comments-container/treatment-comments-container.component";
import {PetRegistrationComponent} from "./components/front-desk/pet-registration/pet-registration.component";
import {RegistrationQueryComponent} from "./components/front-desk/registration-query/registration-query.component";
import {MyConsultingRoomRegistrationDetailComponent} from "./components/my-consulting-room/my-consulting-room-registration-list/my-consulting-room-registration-detail/my-consulting-room-registration-detail.component";
import {MyConsultingRoomRegistrationListComponent} from "./components/my-consulting-room/my-consulting-room-registration-list/my-consulting-room-registration-list.component";
import {DoctorListViewComponent} from "./components/doctor-registration/views/doctor-list-view/doctor-list-view.component";
import {DoctorListItemComponent} from "./components/doctor-registration/views/doctor-list-view/doctor-list-item/doctor-list-item.component";
import {CustomerServiceTreatmentCaseOutletComponent} from "./components/customer-service-treatment-case-list/customer-service-treatment-case-outlet/customer-service-treatment-case-outlet.component";
import {CustomerServiceTreatmentCaseCommentComponent} from "./components/customer-service-treatment-case-list/customer-service-treatment-case-comments/customer-service-treatment-case-comment/customer-service-treatment-case-comment.component";
import {CustomerServiceTreatmentCaseCommentsComponent} from "./components/customer-service-treatment-case-list/customer-service-treatment-case-comments/customer-service-treatment-case-comments.component";
import {CustomerServiceTreatmentCaseListComponent} from "./components/customer-service-treatment-case-list/customer-service-treatment-case-list.component";
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
import {PetOwnerService} from "./services/pet-owner.service";
import {CommentService} from "./services/comment.service";
import {DepartmentService} from "./services/department.service";
import {PetService} from "./services/pet.service";
import {RegistrationService} from "./services/registration.service";
import {TreatmentCaseService} from "./services/treatment-case.service";
import {TreatmentEmployeeService} from "./services/treatment-employee.service";

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
    CustomerComponent,
    TreatmentCommentsContainerComponent,
    PetRegistrationComponent,
    RegistrationQueryComponent,
    MyConsultingRoomRegistrationDetailComponent,
    MyConsultingRoomRegistrationListComponent,
    DoctorListViewComponent,
    DoctorListItemComponent,
    CustomerServiceTreatmentCaseOutletComponent,
    CustomerServiceTreatmentCaseCommentComponent,
    CustomerServiceTreatmentCaseCommentsComponent,
    CustomerServiceTreatmentCaseListComponent,
    FeeQueryComponent,
    MyConsultingRoomComponent,
    PetInfoComponent,
    PetTreatmentComponent,
    PetMedicalTestComponent,
    DoctorRegistrationComponent,
    TimeBasedViewComponent,
    FromNowPipe,
    PetTreatmentDetailComponent,
    EmployeeProfilePictureComponent
  ],
  providers:[
    FrontdeskGuard,
    InpatientManagementGuard,
    MyConsultingRoomGuard,
    TreatmentSettingsGuard,
    PetOwnerService,
    CommentService,
    DepartmentService,
    PetService,
    RegistrationService,
    TreatmentCaseService,
    TreatmentEmployeeService
  ]
})
export class TreatmentModule { }
