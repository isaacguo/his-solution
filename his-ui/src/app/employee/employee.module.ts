import {NgModule} from '@angular/core';

import {EmployeeRoutingModule} from './employee-routing.module';
import {SharedModule} from "../shared/shared.module";
import {EmployeeProfileContainerComponent} from './containers/employee-profile-container/employee-profile-container.component';
import {EmployeeProfileComponent} from './components/employee-profile/employee-profile.component';
import {EmployeeLeaveContainerComponent} from './containers/employee-leave-container/employee-leave-container.component';
import {EmployeeLeaveComponent} from './components/employee-leave/employee-leave.component';
import {EmployeeManagementContainerComponent} from './containers/employee-management-container/employee-management-container.component';
import {EmployeeManagementListViewContainerComponent} from './containers/employee-management-list-view-container/employee-management-list-view-container.component';
import {EmployeeManagementTreeViewContainerComponent} from './containers/employee-management-tree-view-container/employee-management-tree-view-container.component';
import {EmployeeViewSwitcherComponent} from './components/employee-view-switcher/employee-view-switcher.component';
import {EmployeeManagementTreeViewDetailContainerComponent} from './containers/employee-management-tree-view-detail-container/employee-management-tree-view-detail-container.component';
import {EmployeeManagementCategoryTreeComponent} from './components/employee-management-category-tree/employee-management-category-tree.component';
import { EmployeeManagementCategoryDetailComponent } from './components/employee-management-category-detail/employee-management-category-detail.component';
import { EmployeeManagementCreateNewEmployeeComponent } from './components/employee-management-create-new-employee/employee-management-create-new-employee.component';
import { EmployeeManagementListViewComponent } from './components/employee-management-list-view/employee-management-list-view.component';
import { EmployeeCreateUpdateContainerComponent } from './containers/employee-create-update-container/employee-create-update-container.component';
import { EmployeeOperationBarComponent } from './components/employee-operation-bar/employee-operation-bar.component';

@NgModule({
  imports: [
    SharedModule,
    EmployeeRoutingModule
  ],
  declarations: [EmployeeProfileContainerComponent,
    EmployeeProfileComponent,
    EmployeeLeaveContainerComponent,
    EmployeeLeaveComponent,
    EmployeeManagementContainerComponent,
    EmployeeManagementListViewContainerComponent,
    EmployeeManagementTreeViewContainerComponent,
    EmployeeViewSwitcherComponent,
    EmployeeManagementTreeViewDetailContainerComponent,
    EmployeeManagementCategoryTreeComponent,
    EmployeeManagementCategoryDetailComponent,
    EmployeeManagementCreateNewEmployeeComponent,
    EmployeeManagementListViewComponent,
    EmployeeCreateUpdateContainerComponent,
    EmployeeOperationBarComponent]
})
export class EmployeeModule {
}
