import {Component, OnInit} from '@angular/core';
import {EmployeeService} from "../../services/employee/employee.service";
import {Employee} from "../../dto/employee.model";

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
