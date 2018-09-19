import {Component, Input, OnDestroy, OnInit} from '@angular/core';
import {Subscription} from "rxjs/Subscription";
import {PetInfo, PetService} from "../../../../core/services/treatment/pet.service";
import {TreatmentRegistrationModel} from "../../../models/treatment.registration.model";

@Component({
  selector: 'app-my-consulting-room-registration-list',
  templateUrl: './my-consulting-room-registration-list.component.html',
  styleUrls: ['./my-consulting-room-registration-list.component.css']
})
export class MyConsultingRoomRegistrationListComponent implements OnInit, OnDestroy {

  petInfo: PetInfo;
  petInfoChangeSubscription: Subscription;

  @Input()
  registration: TreatmentRegistrationModel;

  constructor(public petService:PetService) {
    this.petInfoChangeSubscription = petService.petInfoChange.subscribe(
      newPetInfo =>
        this.petInfo = newPetInfo);
  }

  ngOnInit() {
  }

  ngOnDestroy(): void {
    this.petInfoChangeSubscription.unsubscribe();
  }

}
