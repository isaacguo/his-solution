import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {MedicalTestQueryContainerComponent} from "./containers/medical-test-query-container/medical-test-query-container.component";
import {MedicalTestSettingsContainerComponent} from "./containers/medical-test-settings-container/medical-test-settings-container.component";
import {MedicalTestSettingsReportTemplatesContainerComponent} from "./containers/medical-test-settings-report-templates-container/medical-test-settings-report-templates-container.component";
import {MedicalTestSettingsDepartmentContainerComponent} from "./containers/medical-test-settings-department-container/medical-test-settings-department-container.component";

const routes: Routes = [
  {
    path: 'query',
    component: MedicalTestQueryContainerComponent
  },
  {

    path: 'settings',
    component: MedicalTestSettingsContainerComponent,
    children: [
      {
        path: 'report-templates/:reportTemplateUuid',
        component: MedicalTestSettingsReportTemplatesContainerComponent
      },
      {
        path: 'report-templates',
        component: MedicalTestSettingsReportTemplatesContainerComponent
      },
      {
        path: 'departments',
        component: MedicalTestSettingsDepartmentContainerComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MedicalTestRoutingModule { }
