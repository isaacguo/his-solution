import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-employee-profile',
  templateUrl: './employee-profile.component.html',
  styleUrls: ['./employee-profile.component.css']
})
export class EmployeeProfileComponent implements OnInit {


  constructor(private router: Router) {
  }

  ngOnInit() {
  }

  onEditProfileButtonClicked()
  {
    this.router.navigate(['employee-profile-edit']);

  }

}
