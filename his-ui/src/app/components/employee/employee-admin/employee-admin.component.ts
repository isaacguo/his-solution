import {Component, OnInit} from '@angular/core';
import {EmployeeService} from "../../../services/employee/employee.service";
import {Employee} from "../../../dto/employee.model";
import {Router} from "@angular/router";

@Component({
  selector: 'app-employee-admin',
  templateUrl: './employee-admin.component.html',
  styleUrls: ['./employee-admin.component.css']
})
export class EmployeeAdminComponent implements OnInit {

  emplyeeList: Employee[] = [];

  constructor(private router: Router, private employeeService: EmployeeService) {
  }

  ngOnInit() {
    this.employeeService.getEmployees().subscribe(r => {
      this.emplyeeList = r;
    })
  }

  onViewButtonClicked(uuid: String) {
    console.log(uuid);
    this.router.navigate(['employee-profile', uuid]);
  }

  onEditButtonClicked(uuid: String) {
    console.log(uuid);
    this.router.navigate(['employee-profile-edit', uuid]);
  }
}
