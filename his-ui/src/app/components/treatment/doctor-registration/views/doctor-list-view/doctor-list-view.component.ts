import {Component, OnInit} from '@angular/core';
import {Doctor} from "../../../../../dto/treatment/doctor.model";
import {DepartmentService} from "../../../../../services/treatment/department.service";
import {ActivatedRoute, Router} from "@angular/router";
import {DoctorRegistrationComponent} from "../../doctor-registration.component";

@Component({
  selector: 'doctor-list-view',
  templateUrl: './doctor-list-view.component.html',
  styleUrls: ['./doctor-list-view.component.css']
})
export class DoctorListViewComponent implements OnInit {

  uuid: string;
  doctors: Doctor[] = [];

  constructor(private departmentService: DepartmentService, private router: Router, private route: ActivatedRoute, private doctorRegistrationComponent: DoctorRegistrationComponent) {

  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.uuid = params['uuid'];
      this.doctors = [];
    });
  }
}
