import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AdminGuard} from "../auth/guards/admin.guard";
import {SettingsComponent} from "./components/settings.component";
import {AuthorizationManagementComponent} from "./components/authorization-management/authorization-management.component";
import {FactoryResetComponent} from "./components/factory-reset/factory-reset.component";

const routes: Routes = [

  {
    path: '',
    canActivate: [AdminGuard],
    component: SettingsComponent,
  },
  {
    path: 'settings-authorization',
    canActivate: [AdminGuard],
    component: AuthorizationManagementComponent
  },
  {
    path: 'settings-factory-reset',
    canActivate: [AdminGuard],
    component: FactoryResetComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SettingsRoutingModule { }
