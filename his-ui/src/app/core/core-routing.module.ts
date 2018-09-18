import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {EmployeeComponent} from "../employee/components/employee.component";
import {EmployeeProfileComponent} from "../employee/components/employee-profile/employee-profile.component";
import {EmployeeProfileEditComponent} from "../employee/components/employee-profile-edit/employee-profile-edit.component";
import {EmployeeLeaveComponent} from "../employee/components/employee-leave/employee-leave.component";
import {EmployeeManagementGuard} from "../employee/guards/employee-management.guard";
import {EmployeeAdminComponent} from "../employee/components/employee-admin/employee-admin.component";
import {EmployeeCreateUpdateComponent} from "../employee/components/employee-create-update/employee-create-update.component";

const routes: Routes = [
  {
    path: 'employee-profile',
    component: EmployeeProfileComponent,
  },
  {
    path: 'employee-profile/:uuid', component: EmployeeProfileComponent
  },
  {
    path: 'employee-profile-edit',
    component: EmployeeProfileEditComponent
  },
  {
    path: 'employee-profile-edit/:uuid', component: EmployeeProfileEditComponent
  },
  {
    path: 'employee-leave',
    component: EmployeeLeaveComponent
  },
  {
    path: 'employee-admin',
    canActivate: [EmployeeManagementGuard],
    component: EmployeeAdminComponent
  },
  {
    path: 'employee-operation/:operation/:updateId',
    component: EmployeeCreateUpdateComponent
  },
  {
    path: 'employee',
    component: EmployeeComponent,
    children: []
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CoreRoutingModule {
}
