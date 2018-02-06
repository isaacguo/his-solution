import {Component, Input, OnInit} from '@angular/core';
import {Doctor} from "../../../../../../dto/doctor.model";

@Component({
  selector: 'doctor-list-item',
  templateUrl: './doctor-list-item.component.html',
  styleUrls: ['./doctor-list-item.component.css']
})
export class DoctorListItemComponent implements OnInit {

  @Input()
  doctor:Doctor;
  constructor() { }

  ngOnInit() {
  }

}
