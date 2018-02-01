import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {EmployeeService} from "../../../services/business/employee/employee.service";
import {Employee} from "../../../dto/employee.model";
import {SexualEnum} from "../../../enums/sexual.enum";
import {EmploymentStatusEnum} from "../../../enums/employment.status.enum";

@Component({
  selector: 'app-employee-profile',
  templateUrl: './employee-profile.component.html',
  styleUrls: ['./employee-profile.component.css']
})
export class EmployeeProfileComponent implements OnInit {

  employee: Employee = {};

  constructor(private employeeService: EmployeeService, private router: Router) {
  }


  ngOnInit() {
    this.employeeService.getMyInfo().subscribe(r => {
      this.employee = r;
      //console.log(SexualEnum[this.employee.gender]);
    })
  }
  getLiteralGender(sexualEnum:SexualEnum):string
  {
    return SexualEnum[sexualEnum];
  }

  getLiteralEmploymentStatus(employmentStatusEnum:EmploymentStatusEnum):string
  {
    return EmploymentStatusEnum[employmentStatusEnum];
  }

  onEditProfileButtonClicked() {
    this.router.navigate(['employee-profile-edit']);
  }

}
