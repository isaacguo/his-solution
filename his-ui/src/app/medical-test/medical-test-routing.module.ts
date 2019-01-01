import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {MedicalTestQueryContainerComponent} from "./containers/medical-test-query-container/medical-test-query-container.component";
import {MedicalTestSettingsContainerComponent} from "./containers/medical-test-settings-container/medical-test-settings-container.component";
import {MedicalTestSettingsReportTemplatesContainerComponent} from "./containers/medical-test-settings-report-templates-container/medical-test-settings-report-templates-container.component";
import {MedicalTestSettingsDepartmentContainerComponent} from "./containers/medical-test-settings-department-container/medical-test-settings-department-container.component";
import {MedicalTestSettingsDepartmentDetailContainerComponent} from "./containers/medical-test-settings-department-detail-container/medical-test-settings-department-detail-container.component";
import {MedicalTestSettingsReportTemplatesDepartmentContainerComponent} from "./containers/medical-test-settings-report-templates-department-container/medical-test-settings-report-templates-department-container.component";
import {MedicalTestSettingsReportTemplateCreateUpdateContainerComponent} from "./containers/medical-test-settings-report-template-create-update-container/medical-test-settings-report-template-create-update-container.component";
import {MedicalTestSettingsReportTemplatesCategoryContainerComponent} from "./containers/medical-test-settings-report-templates-category-container/medical-test-settings-report-templates-category-container.component";

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
          path: 'report-templates',
          component: MedicalTestSettingsReportTemplatesContainerComponent,
          children: [
            {
              path: 'departments/:departmentId',
              component: MedicalTestSettingsReportTemplatesDepartmentContainerComponent,
              children:
                [
                  {
                    path: 'medical-tests/:categoryId',
                    component: MedicalTestSettingsReportTemplatesCategoryContainerComponent,
                  },
                  {
                    path: 'medical-tests/:categoryId/:operation',
                    component: MedicalTestSettingsReportTemplateCreateUpdateContainerComponent
                  },
                  {
                    path: 'medical-tests/:categoryId/:operation/:updateId',
                    component: MedicalTestSettingsReportTemplateCreateUpdateContainerComponent
                  },
                ]
            },
          ]
        },
        {
          path: 'departments',
          component: MedicalTestSettingsDepartmentContainerComponent,
          children:
            [
              {
                path: ':departmentId',
                component: MedicalTestSettingsDepartmentDetailContainerComponent
              }
            ]
        }

      ]
    }
  ]
;

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MedicalTestRoutingModule {
}
