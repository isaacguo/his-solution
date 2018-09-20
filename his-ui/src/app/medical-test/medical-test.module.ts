import {NgModule} from '@angular/core';

import {MedicalTestRoutingModule} from './medical-test-routing.module';
import {SharedModule} from "../shared/shared.module";
import {MedicalTestSettingsComponent} from "./components/medical-test-settings/medical-test-settings.component";
import {MedicalTestSettingsReportCreateUpdateComponent} from "./components/medical-test-settings/medical-test-settings-report-create-update/medical-test-settings-report-create-update.component";
import {MedicalTestSettingsReportComponent} from "./components/medical-test-settings/medical-test-settings-report/medical-test-settings-report.component";
import {MedicalTestSettingsReportTemplateCategoryListComponent} from "./components/medical-test-settings/medical-test-settings-report/medical-test-settings-report-template-category-list/medical-test-settings-report-template-category-list.component";
import {MedicalTestSettingsReportTemplateCategoryDetailComponent} from "./components/medical-test-settings/medical-test-settings-report/medical-test-settings-report-template-category-list/medical-test-settings-report-template-category-detail/medical-test-settings-report-template-category-detail.component";
import {MedicalTestSettingsDepartmentComponent} from "./components/medical-test-settings/medical-test-settings-department/medical-test-settings-department.component";
import {MedicalTestSettingsDepartmentListComponent} from "./components/medical-test-settings/medical-test-settings-department/medical-test-settings-department-list/medical-test-settings-department-list.component";
import {MedicalTestSettingsDepartmentDetailComponent} from "./components/medical-test-settings/medical-test-settings-department/medical-test-settings-department-detail/medical-test-settings-department-detail.component";
import {MedicalTestSettingsDepartmentReportTemplatesComponent} from "./components/medical-test-settings/medical-test-settings-department/medical-test-settings-department-detail/medical-test-settings-department-report-templates/medical-test-settings-department-report-templates.component";
import {MedicalTestReportViewComponent} from "./components/medical-test-report-view/medical-test-report-view.component";
import {MedicalTestReportCreateUpdateComponent} from "./components/medical-test-report-create-update/medical-test-report-create-update.component";
import {MedicalTestQueryComponent} from "./components/medical-test-query/medical-test-query.component";
import {MedicalTestDepartmentService} from "../core/services/medical-test/medical-test-department.service";
import {MedicalTestReportService} from "../core/services/medical-test/medical-test-report.service";
import {MedicalTestReportTemplateService} from "../core/services/medical-test/medical-test-report-template.service";
import {MedicalTestReportTemplateCategoryService} from "../core/services/medical-test/medical-test-report-template-category.service";

@NgModule({
  imports: [
    SharedModule,
    MedicalTestRoutingModule
  ],
  declarations: [
    MedicalTestSettingsComponent,
    MedicalTestSettingsReportCreateUpdateComponent,
    MedicalTestSettingsReportComponent,
    MedicalTestSettingsReportTemplateCategoryListComponent,
    MedicalTestSettingsReportTemplateCategoryDetailComponent,
    MedicalTestSettingsDepartmentComponent,
    MedicalTestSettingsDepartmentListComponent,
    MedicalTestSettingsDepartmentDetailComponent,
    MedicalTestSettingsDepartmentReportTemplatesComponent,
    MedicalTestReportViewComponent,
    MedicalTestReportCreateUpdateComponent,
    MedicalTestQueryComponent
  ],
  providers: [



  ]


})
export class MedicalTestModule {
}
