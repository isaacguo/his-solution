import {NgModule} from '@angular/core';

import {TreatmentRoutingModule} from './treatment-routing.module';
import {SharedModule} from "../shared/shared.module";
import {FrontDeskContainerComponent} from './containers/front-desk-container/front-desk-container.component';
import {FrontDeskComponent} from './components/front-desk/front-desk.component';
import {PetRegistrationContainerComponent} from './containers/pet-registration-container/pet-registration-container.component';
import {RegistrationQueryContainerComponent} from './containers/registration-query-container/registration-query-container.component';
import {RegistrationQueryComponent} from './components/registration-query/registration-query.component';
import {FeeQueryContainerComponent} from './containers/fee-query-container/fee-query-container.component';
import {FeeQueryComponent} from './components/fee-query/fee-query.component';
import {CustomerServiceContainerComponent} from './containers/customer-service-container/customer-service-container.component';
import {CustomerServiceComponent} from './components/customer-service/customer-service.component';
import {CustomerServiceTreatmentCaseContainerComponent} from './containers/customer-service-treatment-case-container/customer-service-treatment-case-container.component';
import {CustomerServiceTreatmentCaseComponent} from './components/customer-service-treatment-case/customer-service-treatment-case.component';
import {CustomerServiceTreatmentCaseInfoContainerComponent} from './containers/customer-service-treatment-case-info-container/customer-service-treatment-case-info-container.component';
import {CustomerServiceTreatmentCaseInfoComponent} from './components/customer-service-treatment-case-info/customer-service-treatment-case-info.component';
import {CustomerServiceTreatmentCaseDetailContainerComponent} from './containers/customer-service-treatment-case-detail-container/customer-service-treatment-case-detail-container.component';
import {CustomerServiceTreatmentCaseDetailComponent} from './components/customer-service-treatment-case-detail/customer-service-treatment-case-detail.component';
import {CustomerServiceTreatmentCaseCommentsContainerComponent} from './containers/customer-service-treatment-case-comments-container/customer-service-treatment-case-comments-container.component';
import {CustomerServiceTreatmentCaseCommentsComponent} from './components/customer-service-treatment-case-comments/customer-service-treatment-case-comments.component';
import {MyConsultingRoomContainerComponent} from './containers/my-consulting-room-container/my-consulting-room-container.component';
import {MyConsultingRoomComponent} from './components/my-consulting-room/my-consulting-room.component';
import {PetInfoContainerComponent} from './containers/pet-info-container/pet-info-container.component';
import {PetInfoComponent} from './components/pet-info/pet-info.component';
import {PetTreatmentContainerComponent} from './containers/pet-treatment-container/pet-treatment-container.component';
import {PetTreatmentComponent} from './components/pet-treatment/pet-treatment.component';
import {TreatmentSettingsContainerComponent} from './containers/treatment-settings-container/treatment-settings-container.component';
import {TreatmentSettingsRoomContainerComponent} from './containers/treatment-settings-room-container/treatment-settings-room-container.component';
import {TreatmentSettingsRoomComponent} from './components/treatment-settings-room/treatment-settings-room.component';
import {TreatmentSettingsBusinessContainerComponent} from './containers/treatment-settings-business-container/treatment-settings-business-container.component';
import {TreatmentSettingsBusinessComponent} from './components/treatment-settings-business/treatment-settings-business.component';
import {PetOwnerInfoComponent} from './components/pet-owner-info/pet-owner-info.component';
import {PetRegistrationPanelComponent} from './components/pet-registration-panel/pet-registration-panel.component';
import {TreatmentCaseQueryResultTableComponent} from './components/treatment-case-query-result-table/treatment-case-query-result-table.component';
import {PetRegistrationListComponent} from './components/pet-registration-list/pet-registration-list.component';
import {MyConsultingRoomRegistrationContainerComponent} from './containers/my-consulting-room-registration-container/my-consulting-room-registration-container.component';
import {PetTreatmentDetailComponent} from './components/pet-treatment-detail/pet-treatment-detail.component';
import {TreatmentPrescriptionsContainerComponent} from './containers/treatment-prescriptions-container/treatment-prescriptions-container.component';
import {TreatmentCaseDetailContainerComponent} from './containers/treatment-case-detail-container/treatment-case-detail-container.component';
import {TreatmentCaseDetailComponent} from './components/treatment-case-detail/treatment-case-detail.component';
import {TreatmentMedicalTestContainerComponent} from './containers/treatment-medical-test-container/treatment-medical-test-container.component';
import {TreatmentMedicalTestDetailContainerComponent} from './containers/treatment-medical-test-detail-container/treatment-medical-test-detail-container.component';
import {TreatmentMedicalTestComponent} from './components/treatment-medical-test/treatment-medical-test.component';
import { TreatmentPrescriptionsComponent } from './components/treatmnet-prescriptions/treatment-prescriptions.component';
import { TreatmnetPrescriptionDetailComponent } from './components/treatmnet-prescription-detail/treatmnet-prescription-detail.component';
import { TreatmentPrescriptionDetailContainerComponent } from './containers/treatment-prescription-detail-container/treatment-prescription-detail-container.component';
import { PetOwnerSelectTableComponent } from './components/pet-owner-select-table/pet-owner-select-table.component';
import { PetsSelectTableComponent } from './components/pets-select-table/pets-select-table.component';
import { PetOwnerCreateUpdateComponent } from './components/pet-owner-create-update/pet-owner-create-update.component';
import { PetCreateUpdateComponent } from './components/pet-create-update/pet-create-update.component';
import { TreatmentSettingsRoomDetailContainerComponent } from './containers/treatment-settings-room-detail-container/treatment-settings-room-detail-container.component';
import { TreatmentSettingsRoomOpenSwitchComponent } from './components/treatment-settings-room-open-switch/treatment-settings-room-open-switch.component';
import { TreatmentSettingsRoomEmployeeOpenSwitchComponent } from './components/treatment-settings-room-employee-open-switch/treatment-settings-room-employee-open-switch.component';
import { TreatmentSettingsRoomEmployeeOpenSwitchDetailComponent } from './components/treatment-settings-room-employee-open-switch-detail/treatment-settings-room-employee-open-switch-detail.component';
import { PetOwnerBriefInfoComponent } from './components/pet-owner-brief-info/pet-owner-brief-info.component';
import { SelectableTreatmentCaseTableComponent } from './components/selectable-treatment-case-table/selectable-treatment-case-table.component';
import { CustomerServiceTreatmentCaseCommentComponent } from './components/customer-service-treatment-case-comment/customer-service-treatment-case-comment.component';
import {CustomerServicePetInfoComponent} from "./components/customer-service-pet-info/customer-service-pet-info.component";
import { CreateMedicalTestsComponent } from './components/create-medical-tests/create-medical-tests.component';
import { TreatmentMedicalTestReportDetailComponent } from './components/treatment-medical-test-report-detail/treatment-medical-test-report-detail.component';
import { TreatmentPrescriptionListComponent } from './components/treatment-prescription-list/treatment-prescription-list.component';

@NgModule({
  imports: [
    SharedModule,
    TreatmentRoutingModule
  ],
  declarations: [FrontDeskContainerComponent,
    FrontDeskComponent,
    PetRegistrationContainerComponent,
    RegistrationQueryContainerComponent,
    RegistrationQueryComponent,
    FeeQueryContainerComponent,
    FeeQueryComponent,
    PetInfoComponent,
    PetOwnerInfoComponent,
    CustomerServiceContainerComponent,
    CustomerServiceComponent,
    CustomerServiceTreatmentCaseContainerComponent,
    CustomerServiceTreatmentCaseComponent,
    CustomerServiceTreatmentCaseInfoContainerComponent,
    CustomerServiceTreatmentCaseInfoComponent,
    CustomerServiceTreatmentCaseDetailContainerComponent,
    CustomerServiceTreatmentCaseDetailComponent,
    CustomerServiceTreatmentCaseCommentsContainerComponent,
    CustomerServiceTreatmentCaseCommentsComponent,
    MyConsultingRoomContainerComponent,
    MyConsultingRoomComponent,
    PetInfoContainerComponent,
    PetTreatmentContainerComponent,
    PetTreatmentComponent,
    TreatmentSettingsContainerComponent,
    TreatmentSettingsRoomContainerComponent,
    TreatmentSettingsRoomComponent,
    TreatmentSettingsBusinessContainerComponent,
    TreatmentSettingsBusinessComponent,
    PetRegistrationPanelComponent,
    TreatmentCaseQueryResultTableComponent,
    PetRegistrationListComponent,
    MyConsultingRoomRegistrationContainerComponent,
    PetTreatmentDetailComponent,
    TreatmentPrescriptionsContainerComponent,
    TreatmentCaseDetailContainerComponent,
    TreatmentCaseDetailComponent,
    TreatmentMedicalTestContainerComponent,
    TreatmentMedicalTestDetailContainerComponent,
    TreatmentMedicalTestComponent,
    TreatmentPrescriptionsComponent,
    TreatmnetPrescriptionDetailComponent,
    TreatmentPrescriptionDetailContainerComponent,
    PetOwnerSelectTableComponent,
    PetsSelectTableComponent,
    PetOwnerCreateUpdateComponent,
    PetCreateUpdateComponent,
    TreatmentSettingsRoomDetailContainerComponent,
    TreatmentSettingsRoomOpenSwitchComponent,
    TreatmentSettingsRoomEmployeeOpenSwitchComponent,
    TreatmentSettingsRoomEmployeeOpenSwitchDetailComponent,
    PetOwnerBriefInfoComponent,
    SelectableTreatmentCaseTableComponent,
    CustomerServiceTreatmentCaseCommentComponent,
    CustomerServicePetInfoComponent,
    CreateMedicalTestsComponent,
    TreatmentMedicalTestReportDetailComponent,
    TreatmentPrescriptionListComponent
    ]
})
export class TreatmentModule {
}
