import {NgModule} from '@angular/core';

import {MedicalTestRoutingModule} from './medical-test-routing.module';
import {SharedModule} from "../shared/shared.module";
import {MedicalTestQueryContainerComponent} from './containers/medical-test-query-container/medical-test-query-container.component';
import {MedicalTestQueryComponent} from './components/medical-test-query/medical-test-query.component';
import {MedicalTestSettingsContainerComponent} from './containers/medical-test-settings-container/medical-test-settings-container.component';
import {MedicalTestSettingsComponent} from './components/medical-test-settings/medical-test-settings.component';
import {MedicalTestSettingsReportTemplatesContainerComponent} from './containers/medical-test-settings-report-templates-container/medical-test-settings-report-templates-container.component';
import {MedicalTestSettingsReportTemplateListComponent} from './components/medical-test-settings-report-template-list/medical-test-settings-report-template-list.component';
import {MedicalTestSettingsDepartmentContainerComponent} from './containers/medical-test-settings-department-container/medical-test-settings-department-container.component';
import {MedicalTestSettingsDepartmentComponent} from './components/medical-test-settings-department/medical-test-settings-department.component';
import { MedicalTestSettingsDepartmentDetailContainerComponent } from './containers/medical-test-settings-department-detail-container/medical-test-settings-department-detail-container.component';
import { MedicalTestSettingsRoomDetailComponent } from './components/medical-test-settings-room-detail/medical-test-settings-room-detail.component';
import { MedicalTestSettingsReportTemplatesDepartmentContainerComponent } from './containers/medical-test-settings-report-templates-department-container/medical-test-settings-report-templates-department-container.component';

@NgModule({
  imports: [
    SharedModule,
    MedicalTestRoutingModule
  ],
  declarations: [MedicalTestQueryContainerComponent,
    MedicalTestQueryComponent,
    MedicalTestSettingsContainerComponent,
    MedicalTestSettingsComponent,
    MedicalTestSettingsReportTemplatesContainerComponent,
    MedicalTestSettingsReportTemplateListComponent,
    MedicalTestSettingsDepartmentContainerComponent,
    MedicalTestSettingsDepartmentComponent,
    MedicalTestQueryComponent,
    MedicalTestSettingsDepartmentDetailContainerComponent,
    MedicalTestSettingsRoomDetailComponent,
    MedicalTestSettingsReportTemplatesDepartmentContainerComponent]
})
export class MedicalTestModule { }
