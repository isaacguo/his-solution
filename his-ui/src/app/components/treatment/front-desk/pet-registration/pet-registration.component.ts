import {Component, OnInit} from '@angular/core';
import {ModalComponent} from "ng2-bs3-modal/ng2-bs3-modal";

@Component({
  selector: 'app-pet-registration',
  templateUrl: './pet-registration.component.html',
  styleUrls: ['./pet-registration.component.css']
})
export class PetRegistrationComponent implements OnInit {

  constructor() {
  }

  ngOnInit() {
  }


  onCreatePetOwnerButtonClicked(createPetOwnerModal: ModalComponent) {
    createPetOwnerModal.open();

  }

  onCreateNewPetButtonClicked(createPetModal: ModalComponent) {
    createPetModal.open();

  }

  onCreatePetOwnerModalClosed() {

  }

  onCreatePetModalClosed() {

  }
}
