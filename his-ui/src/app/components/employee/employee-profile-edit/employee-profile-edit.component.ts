import { Component, OnInit } from '@angular/core';
import {EmployeeService} from "../../../services/employee/employee.service";
import {Employee} from "../../../dto/employee.model";
import {ActivatedRoute, Router} from "@angular/router";
import {error} from "util";

@Component({
  selector: 'app-employee-profile-edit',
  templateUrl: './employee-profile-edit.component.html',
  styleUrls: ['./employee-profile-edit.component.css']
})
export class EmployeeProfileEditComponent implements OnInit {

  uuid: string;
  employee: Employee;

  constructor(private employeeService: EmployeeService, private router: Router, private route: ActivatedRoute) {

  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.uuid = params['uuid'];
      if (this.uuid != null) {
        this.employeeService.getEmployeeInfoByEmployeeUuid(this.uuid).subscribe(r=>{
          this.employee=r;
        })
      }
      else {
        //TODO:should throw error
        this.employee={};
      }
    });
  }
}
