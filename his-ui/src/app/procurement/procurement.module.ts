import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProcurementRoutingModule } from './procurement-routing.module';
import { ProcurementManagementContainerComponent } from './containers/procurement-management-container/procurement-management-container.component';
import { ProcurementManagementComponent } from './components/procurement-management/procurement-management.component';
import { ProcurementSettingsContainerComponent } from './containers/procurement-settings-container/procurement-settings-container.component';
import { ProcurementSettingsComponent } from './components/procurement-settings/procurement-settings.component';
import { ProcurementSettingsVendorsContainerComponent } from './containers/procurement-settings-vendors-container/procurement-settings-vendors-container.component';
import { ProcurementSettingsVendorsComponent } from './components/procurement-settings-vendors/procurement-settings-vendors.component';

@NgModule({
  imports: [
    CommonModule,
    ProcurementRoutingModule
  ],
  declarations: [ProcurementManagementContainerComponent, ProcurementManagementComponent, ProcurementSettingsContainerComponent, ProcurementSettingsComponent, ProcurementSettingsVendorsContainerComponent, ProcurementSettingsVendorsComponent]
})
export class ProcurementModule { }
