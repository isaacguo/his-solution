import {NgModule} from '@angular/core';

import {SettingsRoutingModule} from './settings-routing.module';
import {SharedModule} from "../shared/shared.module";
import {AuthorizationContainerComponent} from './containers/authorization-container/authorization-container.component';
import {AuthorizationComponent} from './components/authorization/authorization.component';
import {FactoryResetContainerComponent} from './containers/factory-reset-container/factory-reset-container.component';
import {FactoryResetComponent} from './components/factory-reset/factory-reset.component';
import {DataBackupContainerComponent} from './containers/data-backup-container/data-backup-container.component';
import {DataBackupComponent} from './components/data-backup/data-backup.component';
import {DataRecoveryContainerComponent} from './containers/data-recovery-container/data-recovery-container.component';
import {DataRecoveryComponent} from './components/data-recovery/data-recovery.component';
import {SecurityOperationPanelComponent} from "./components/security-operation-panel/security-operation-panel.component";

@NgModule({
  imports: [
    SharedModule,
    SettingsRoutingModule
  ],
  declarations: [AuthorizationContainerComponent,
    AuthorizationComponent,
    FactoryResetContainerComponent,
    FactoryResetComponent,
    SecurityOperationPanelComponent,
    DataBackupContainerComponent,
    DataBackupComponent,
    DataRecoveryContainerComponent,
    DataRecoveryComponent]
})
export class SettingsModule {
}
