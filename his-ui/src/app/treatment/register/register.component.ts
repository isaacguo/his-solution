import {Component, OnInit} from '@angular/core';
import {DepartmentService} from "../../../services/treatment/department.service";
import {Department} from "../../../dto/treatment/department.model";
import {Router} from "@angular/router";

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
