import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
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

  uuid: string;
  employee: Employee = {};

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
        this.employeeService.getMyInfo().subscribe(r => {
          this.employee = r;
          //console.log(SexualEnum[this.employee.gender]);
        })
      }
    });
  }

  getLiteralGender(sexualEnum: SexualEnum): string {
    return SexualEnum[sexualEnum];
  }

  getLiteralEmploymentStatus(employmentStatusEnum: EmploymentStatusEnum): string {
    return EmploymentStatusEnum[employmentStatusEnum];
  }

  onEditProfileButtonClicked() {
    this.router.navigate(['employee-profile-edit',this.employee.uuid]);
  }

}
