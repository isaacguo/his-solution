import { Component, OnInit } from '@angular/core';
import {Doctor} from "../../../../../dto/doctor.model";
import {DepartmentService} from "../../../../../services/treatment/department.service";
import {ActivatedRoute, Router} from "@angular/router";
import {RegisterComponent} from "../../../register/register.component";
import {DoctorRegistrationComponent} from "../../doctor-registration.component";

@Component({
  selector: 'doctor-list-view',
  templateUrl: './doctor-list-view.component.html',
  styleUrls: ['./doctor-list-view.component.css']
})
export class DoctorListViewComponent implements OnInit {

  uuid: string;
  doctors:Doctor[]=[];

  constructor(private departmentService: DepartmentService, private router: Router, private route: ActivatedRoute, private doctorRegistrationComponent:DoctorRegistrationComponent) {

  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.uuid = params['uuid'];
      if (this.uuid != null) {
        this.departmentService.getDoctorsInDepartmentByUuid(this.uuid).subscribe(r=>{
          this.doctors=r;
          this.doctorRegistrationComponent.uuid=this.uuid;
        })
      }
      else {
        //TODO:should throw error
        this.doctors=[];
      }
    });
  }
}
