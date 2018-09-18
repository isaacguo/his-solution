import {NgModule} from '@angular/core';

import {SettingsRoutingModule} from './settings-routing.module';
import {SettingsComponent} from "./components/settings.component";
import {AuthorizationManagementComponent} from "./components/authorization-management/authorization-management.component";
import {SecurityOperationPanelComponent} from "./components/authorization-management/security-operation-panel/security-operation-panel.component";
import {FactoryResetComponent} from "./components/factory-reset/factory-reset.component";
import {SharedModule} from "../shared/shared.module";

@NgModule({
  imports: [
    SharedModule,
    SettingsRoutingModule
  ],
  declarations: [
    SettingsComponent,
    AuthorizationManagementComponent,
    SecurityOperationPanelComponent,
    FactoryResetComponent
  ]
})
export class SettingsModule { }
