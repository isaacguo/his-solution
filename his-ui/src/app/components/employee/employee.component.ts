import {Component, OnInit} from '@angular/core';
import {Employee} from "../../core/models/employee/employee.model";
import {EmployeeService} from "../../core/services/employee/employee.service";

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  employees: Employee[];

  constructor(private employeeService: EmployeeService) {
  }

  ngOnInit() {
    this.employeeService.getEmployees().subscribe(r => {
      this.employees = r;
    })
  }


}
