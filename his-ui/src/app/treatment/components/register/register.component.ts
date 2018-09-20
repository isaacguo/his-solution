import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {DepartmentService} from "../../../core/services/treatment/department.service";
import {Department} from "../../models/department.model";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {


  departments: Department[] = [];

  constructor(private departmentService: DepartmentService, private router: Router) {
  }

  ngOnInit() {
    /*
    this.departmentService.getDepartments().subscribe(r => {
      this.departments = r;
    })
    */
  }


  onDepartmentClicked(department: Department) {
    this.router.navigate(['doctor-registration','doctor-list-view',department.depId]);
  }
}
