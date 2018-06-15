import {Component, OnInit} from '@angular/core';
import {EmployeeService} from "../../../services/employee/employee.service";
import {Employee} from "../../../dto/employee/employee.model";
import {Router} from "@angular/router";
import {EmployeeListItem} from "../../../dto/employee/employee-list-item.model";
import {OperationEnum} from "../../../enums/operation.enum";

@Component({
  selector: 'app-employee-admin',
  templateUrl: './employee-admin.component.html',
  styleUrls: ['./employee-admin.component.css']
})
export class EmployeeAdminComponent implements OnInit {

  emplyeeList: EmployeeListItem[] = [];

  constructor(private router: Router, private employeeService: EmployeeService) {
  }

  ngOnInit() {

  }

  onViewButtonClicked(uuid: String) {
    this.router.navigate(['employee-profile', uuid]);
  }

  onEditButtonClicked(uuid: String) {
    this.router.navigate(['employee-profile-edit', uuid]);
  }

  onAddNewEmployeeButtonClicked() {
    this.router.navigate(['employee-operation', OperationEnum.CREATE]);

  }

  get showEmployeeView(): boolean {
    return this.employeeService.showEmployeeView;
  }

  onShowEmployeeViewEnabled(event: boolean) {
    this.employeeService.showEmployeeView=event;
  }
}
