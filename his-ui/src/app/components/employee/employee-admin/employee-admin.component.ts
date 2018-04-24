import {Component, OnInit} from '@angular/core';
import {EmployeeService} from "../../../services/employee/employee.service";
import {Employee} from "../../../dto/employee.model";
import {Router} from "@angular/router";
import {EmployeeListItem} from "../../../dto/employee/employee-list-item.model";
import {OperationEnum} from "../../../enums/operation.enum";

@Component({
  selector: 'app-employee-admin',
  templateUrl: './employee-admin.component.html',
  styleUrls: ['./employee-admin.component.css']
})
export class EmployeeAdminComponent implements OnInit {

  emplyeeList: EmployeeListItem[] = [];

  constructor(private router: Router, private employeeService: EmployeeService) {
  }

  ngOnInit() {
    /*
    this.employeeService.getEmployeeList().subscribe(r => {
      this.emplyeeList = r;
    })
    */
  }

  onViewButtonClicked(uuid: String) {
    console.log(uuid);
    this.router.navigate(['employee-profile', uuid]);
  }

  onEditButtonClicked(uuid: String) {
    console.log(uuid);
    this.router.navigate(['employee-profile-edit', uuid]);
  }

  onAddNewEmployeeButtonClicked() {
    this.router.navigate(['employee-operation', OperationEnum.CREATE]);

  }
}
