import {Component, Input, OnChanges, OnDestroy, OnInit, SimpleChanges} from '@angular/core';
import {MyConsultingRoomComponent} from "../my-consulting-room.component";
import {PetOwner} from "../../../../dto/pet-owner.model";
import {Pet} from "../../../../dto/pet.model";
import {PetInfo, PetService} from "../../../../services/treatment/pet.service";
import {Subscription} from "rxjs/Subscription";

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
    this.currentPetOwner = this.petService.selectedPetOwner;
    this.selectedPet = this.petService.selectedPet;
  }

  onModifyOwnerButtonClicked(createPetOwnerModal)
  {

  }
}
