import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {MedicalTestQueryComponent} from "./components/medical-test-query/medical-test-query.component";
import {MedicalTestReportCreateUpdateComponent} from "./components/medical-test-report-create-update/medical-test-report-create-update.component";
import {MedicalTestSettingsComponent} from "./components/medical-test-settings/medical-test-settings.component";
import {MedicalTestSettingsReportComponent} from "./components/medical-test-settings/medical-test-settings-report/medical-test-settings-report.component";
import {MedicalTestSettingsReportCreateUpdateComponent} from "./components/medical-test-settings/medical-test-settings-report-create-update/medical-test-settings-report-create-update.component";
import {MedicalTestSettingsDepartmentComponent} from "./components/medical-test-settings/medical-test-settings-department/medical-test-settings-department.component";

const routes: Routes = [
  {
    path: 'medical-test-query',
    component: MedicalTestQueryComponent
  },
  {
    path: 'medical-test-report/:operation/:reportType',
    component: MedicalTestReportCreateUpdateComponent
  },
  {

    path: 'medical-test-settings',
    component: MedicalTestSettingsComponent,
    children: [
      {
        path: 'report-templates',
        component: MedicalTestSettingsReportComponent
      },
      {
        path: 'report-templates/:operation',
        component: MedicalTestSettingsReportCreateUpdateComponent
      },
      {
        path: 'report-templates/:operation/:updateId',
        component: MedicalTestSettingsReportCreateUpdateComponent
      },
      {
        path: 'departments',
        component: MedicalTestSettingsDepartmentComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MedicalTestRoutingModule { }
