import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {EmployeeRoutingModule} from './employee-routing.module';
import {EmployeeComponent} from "./components/employee.component";
import {EmployeeProfileComponent} from "./components/employee-profile/employee-profile.component";
import {EmployeeLeaveComponent} from "./components/employee-leave/employee-leave.component";
import {EmployeeAdminComponent} from "./components/employee-admin/employee-admin.component";
import {EmployeeProfileEditComponent} from "./components/employee-profile-edit/employee-profile-edit.component";
import {EmployeeProfilePictureComponent} from "./components/employee-profile-picture/employee-profile-picture.component";
import {EmployeeAdminListOnlyComponent} from "./components/employee-admin/employee-admin-list-only/employee-admin-list-only.component";
import {EmployeeAdminDetailComponent} from "./components/employee-admin/employee-admin-detail/employee-admin-detail.component";
import {EmployeeAdminListComponent} from "./components/employee-admin/employee-admin-list/employee-admin-list.component";
import {EmployeeCreateUpdateComponent} from "./components/employee-create-update/employee-create-update.component";
import {EmployeeManagementGuard} from "./guards/employee-management.guard";

@NgModule({
  imports: [
    CommonModule,
    EmployeeRoutingModule,

    EmployeeComponent,
    EmployeeProfileComponent,
    EmployeeLeaveComponent,
    EmployeeProfileEditComponent,
    EmployeeAdminComponent,
    EmployeeCreateUpdateComponent,
    EmployeeAdminListComponent,
    EmployeeAdminDetailComponent,
    EmployeeAdminListOnlyComponent,
    EmployeeProfilePictureComponent,

  ],
  declarations: [],
  providers:[
    EmployeeManagementGuard
  ]
})
export class EmployeeModule {
}
