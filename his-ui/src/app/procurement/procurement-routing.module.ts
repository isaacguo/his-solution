import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {ProcurementManagementContainerComponent} from "./containers/procurement-management-container/procurement-management-container.component";
import {ProcurementSettingsContainerComponent} from "./containers/procurement-settings-container/procurement-settings-container.component";
import {ProcurementSettingsVendorsContainerComponent} from "./containers/procurement-settings-vendors-container/procurement-settings-vendors-container.component";

const routes: Routes = [
  {
    path: '',
    component: ProcurementManagementContainerComponent
  },
  {
    path: 'procurement-settings',
    component: ProcurementSettingsContainerComponent,
    children: [
      {
        path: 'vendors',
        component: ProcurementSettingsVendorsContainerComponent
      },
    ]
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProcurementRoutingModule {
}
