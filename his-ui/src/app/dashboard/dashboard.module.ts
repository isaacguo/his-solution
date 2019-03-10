import {NgModule} from '@angular/core';

import {DashboardRoutingModule} from './dashboard-routing.module';
import {DashboardContainerComponent} from './containers/dashboard-container/dashboard-container.component';
import {DashboardComponent} from './components/dashboard/dashboard.component';
import {SharedModule} from "../shared/shared.module";

@NgModule({
  imports: [
    SharedModule,
    DashboardRoutingModule
  ],
  declarations: [DashboardContainerComponent, DashboardComponent]
})
export class DashboardModule {
}
