import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {EmployeeProfileContainerComponent} from "./containers/employee-profile-container/employee-profile-container.component";
import {EmployeeLeaveContainerComponent} from "./containers/employee-leave-container/employee-leave-container.component";
import {EmployeeManagementContainerComponent} from "./containers/employee-management-container/employee-management-container.component";
import {EmployeeManagementTreeViewContainerComponent} from "./containers/employee-management-tree-view-container/employee-management-tree-view-container.component";
import {EmployeeManagementListViewContainerComponent} from "./containers/employee-management-list-view-container/employee-management-list-view-container.component";
import {EmployeeManagementTreeViewDetailContainerComponent} from "./containers/employee-management-tree-view-detail-container/employee-management-tree-view-detail-container.component";
import {EmployeeCreateUpdateContainerComponent} from "./containers/employee-create-update-container/employee-create-update-container.component";

const routes: Routes = [
  {
    path: 'management',
    component: EmployeeManagementContainerComponent,
    children: [
      {
        path: 'tree',
        component: EmployeeManagementTreeViewContainerComponent,
        children: [
          {
            path: 'departments/:departmentId',
            component: EmployeeManagementTreeViewDetailContainerComponent
          },
          {
            path: 'departments/:departmentId/:operation',
            component:EmployeeCreateUpdateContainerComponent
          },
          {
            path: 'departments/:departmentId/:employeeUuid/:operation',
            component:EmployeeCreateUpdateContainerComponent
          },
        ]
      },
      {
        path: 'list',
        component: EmployeeManagementListViewContainerComponent
      },
      {
        path: '**',
        redirectTo: 'tree'
      }
    ]
  },
  {
    path: 'profile',
    component: EmployeeProfileContainerComponent,
    children: [
      {
        path: ''
      }
    ]
  },
  {
    path: 'profile/:uuid',
    component: EmployeeProfileContainerComponent
  },
  {
    path: 'leave',
    component: EmployeeLeaveContainerComponent
  }

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EmployeeRoutingModule {
}
