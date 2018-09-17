import {Component, OnInit} from '@angular/core';
import {OperationEnum} from "../../../../enums/operation.enum";
import {Router} from "@angular/router";
import {EmployeeService} from "../../../../core/services/employee/employee.service";
import {Employee} from "../../../../core/models/employee/employee.model";

@Component({
  selector: 'app-employee-admin-list-only',
  templateUrl: './employee-admin-list-only.component.html',
  styleUrls: ['./employee-admin-list-only.component.css']
})
export class EmployeeAdminListOnlyComponent implements OnInit {

  employeeList: Employee[] = [];

  constructor(private router: Router, private employeeService: EmployeeService) {
  }

  ngOnInit() {
    this.loadData();
  }

  loadData() {
    this.employeeService.getEmployees().subscribe(r => {
      this.employeeList = r;
    });
  }

  onViewButtonClicked(uuid: String) {
    this.router.navigate(['employee-profile', uuid]);
  }

  onEditButtonClicked(uuid: String) {
    this.router.navigate(['employee-operation', OperationEnum.UPDATE, uuid]);
  }

}
