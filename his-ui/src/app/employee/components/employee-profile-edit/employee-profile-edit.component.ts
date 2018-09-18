import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {EmployeeService} from "../../../core/services/employee.service";

@Component({
  selector: 'app-employee-profile-edit',
  templateUrl: './employee-profile-edit.component.html',
  styleUrls: ['./employee-profile-edit.component.css']
})
export class EmployeeProfileEditComponent implements OnInit {

  uuid: string;
  employee: any;

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
