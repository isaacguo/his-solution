import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {EmployeeService} from "../../../services/business/employee/employee.service";
import {Employee} from "../../../dto/employee.model";

@Component({
  selector: 'app-employee-profile',
  templateUrl: './employee-profile.component.html',
  styleUrls: ['./employee-profile.component.css']
})
export class EmployeeProfileComponent implements OnInit {

  employee: Employee = {};

  constructor(private employeeService: EmployeeService, private router: Router) {
  }


  getDateString(date:Date):number
  {
    console.log(date);
    return date.valueOf();
  }
  ngOnInit() {
    this.employeeService.getMyInfo().subscribe(r => {
      this.employee = r;
    })
  }

  onEditProfileButtonClicked() {
    this.router.navigate(['employee-profile-edit']);
  }

}
