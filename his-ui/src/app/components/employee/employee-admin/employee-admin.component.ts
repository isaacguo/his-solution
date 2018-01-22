import {Component, OnInit} from '@angular/core';
import {EmployeeService} from "../../../services/business/employee/employee.service";
import {Employee} from "../../../dto/employee.model";

@Component({
  selector: 'app-employee-admin',
  templateUrl: './employee-admin.component.html',
  styleUrls: ['./employee-admin.component.css']
})
export class EmployeeAdminComponent implements OnInit {

  emplyeeList: Employee[] = [];

  constructor(private employeeService: EmployeeService) {
  }

  ngOnInit() {
    this.employeeService.getEmployees().subscribe(r => {
      this.emplyeeList = r;
    })
  }

}
