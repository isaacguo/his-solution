import {Component, Input, OnInit} from '@angular/core';
import {TreatmentRegistrationModel} from "../../../../dto/treatment/treatment.registration.model";
import {PetService} from "../../../../services/treatment/pet.service";

@Component({
  selector: 'app-my-consulting-room-registration-list',
  templateUrl: './my-consulting-room-registration-list.component.html',
  styleUrls: ['./my-consulting-room-registration-list.component.css']
})
export class MyConsultingRoomRegistrationListComponent implements OnInit {

  @Input()
  registration: TreatmentRegistrationModel;

  constructor(public pet:PetService) {}

  ngOnInit() {
  }

}
