import {Component, EventEmitter, OnInit, Output, ViewChild} from '@angular/core';
import {AbstractItemSelectableTableComponent} from "../../../shared/components/abstract-item-selectable-table/abstract-item-selectable-table.component";
import {Pet} from "../../models/pet.model";
import {ModalComponent} from "ng2-bs3-modal/ng2-bs3-modal";

@Component({
  selector: 'app-pets-select-table',
  templateUrl: './pets-select-table.component.html',
  styleUrls: ['./pets-select-table.component.css']
})
export class PetsSelectTableComponent extends AbstractItemSelectableTableComponent<Pet> implements OnInit {


  pet: Pet;

  constructor() {
    super();
  }

  @ViewChild("updatePetModal")
  updatePetModal: ModalComponent;
  @Output()
  petUpdated=new EventEmitter<any>()

  ngOnInit() {
  }

  onUpdatePetButtonClicked(pet: Pet) {
    this.pet = pet;
    this.updatePetModal.open();
  }

  onRemovePetButtonClicked(pet: Pet) {

  }

  onPetUpdated(event)
  {
    this.petUpdated.emit(event);
    this.updatePetModal.dismiss();
  }
}
