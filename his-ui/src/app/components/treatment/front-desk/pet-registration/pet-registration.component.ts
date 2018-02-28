import {Component, OnInit} from '@angular/core';
import {ModalComponent} from "ng2-bs3-modal/ng2-bs3-modal";
import {Pet} from "../../../../dto/pet.model";
import {PetOwner} from "../../../../dto/pet-owner.model";
import {PetOwnerService} from "../../../../services/treatment/pet-owner.service";

@Component({
  selector: 'app-pet-registration',
  templateUrl: './pet-registration.component.html',
  styleUrls: ['./pet-registration.component.css']
})
export class PetRegistrationComponent implements OnInit {

  findByPetOwnerNameText: string;
  newPetOwner: PetOwner = {}
  newPet: Pet = {};

  currentPetOwner: PetOwner = {};

  constructor(public petOwnerService: PetOwnerService) {
  }

  ngOnInit() {
  }


  onCreatePetOwnerButtonClicked(createPetOwnerModal: ModalComponent) {
    this.newPetOwner = {};
    createPetOwnerModal.open();

  }

  onCreateNewPetButtonClicked(createPetModal: ModalComponent) {
    this.newPet = {};
    createPetModal.open();

  }

  onCreatePetOwnerModalClosed() {
    this.petOwnerService.createPetOwner(this.newPetOwner).subscribe(r => {
      this.currentPetOwner = r;
    });
  }

  onCreatePetModalClosed() {
    this.newPet.petOwner = this.currentPetOwner;
    this.petOwnerService.addPet(this.newPet).subscribe(r => {
      this.currentPetOwner = r;
    });
  }

  onFindPetOwnerButtonClicked() {
    if (this.findByPetOwnerNameText) {
      this.petOwnerService.findPetOwnerByName(this.findByPetOwnerNameText).subscribe(r => {
        if (r.length == 1)
          this.currentPetOwner = r[0];
      });
    }
    else {
      console.log("empty");
    }
  }

  onClearButtonClicked() {
    this.findByPetOwnerNameText = null;
  }

  onRemovePetButtonClicked(pet: Pet) {
    pet.petOwner = {};
    pet.petOwner.id = this.currentPetOwner.id;
    this.petOwnerService.deletePet(pet).subscribe(r => {
      this.currentPetOwner = r;
    });
  }
}
