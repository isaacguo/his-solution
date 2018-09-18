import {Component, OnDestroy, OnInit} from '@angular/core';
import {MyConsultingRoomComponent} from "../my-consulting-room.component";
import {Subscription} from "rxjs/Subscription";
import {PetInfo, PetService} from "../../../services/pet.service";
import {PetOwner} from "../../../models/pet-owner.model";
import {Pet} from "../../../models/pet.model";

@Component({
  selector: 'app-pet-info',
  templateUrl: './pet-info.component.html',
  styleUrls: ['./pet-info.component.css']
})
export class PetInfoComponent implements OnInit, OnDestroy {


  ngOnDestroy(): void {
    this.petInfoChangeSubscription.unsubscribe();
  }


  petInfo: PetInfo;
  petInfoChangeSubscription: Subscription;

  currentPetOwner: PetOwner;
  selectedPet: Pet;

  constructor(public myConsultingRoomComponent: MyConsultingRoomComponent, public petService: PetService) {

    this.petInfoChangeSubscription = petService.petInfoChange.subscribe(
      newPetInfo =>
        this.petInfo = newPetInfo);
  }

  ngOnInit() {
    this.currentPetOwner = this.petInfo.petOwner;
    this.selectedPet = this.petInfo.pet;
  }

  onModifyOwnerButtonClicked(createPetOwnerModal)
  {

  }
}
