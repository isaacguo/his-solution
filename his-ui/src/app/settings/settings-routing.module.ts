import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AuthorizationContainerComponent} from "./containers/authorization-container/authorization-container.component";
import {FactoryResetContainerComponent} from "./containers/factory-reset-container/factory-reset-container.component";
import {DataBackupContainerComponent} from "./containers/data-backup-container/data-backup-container.component";
import {DataRecoveryContainerComponent} from "./containers/data-recovery-container/data-recovery-container.component";

const routes: Routes = [


  {
    path: 'authorization',
    component: AuthorizationContainerComponent
  },
  {
    path: 'factory-reset',
    component: FactoryResetContainerComponent
  },
  {
    path: 'data-backup',
    component: DataBackupContainerComponent
  },
  {
    path: 'data-recovery',
    component: DataRecoveryContainerComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SettingsRoutingModule {
}
