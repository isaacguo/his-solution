import {
  ChangeDetectionStrategy,
  Component,
  EventEmitter,
  Input,
  OnChanges,
  OnInit,
  Output,
  SimpleChanges,
  ViewChild
} from '@angular/core';
import {Pet} from "../../models/pet.model";
import {ModalComponent} from "ng2-bs3-modal/ng2-bs3-modal";
import {GenderEnum} from "../../../core/enums/gender.enum";

@Component({
  selector: 'app-pet-owner-info',
  templateUrl: './pet-owner-info.component.html',
  styleUrls: ['./pet-owner-info.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class PetOwnerInfoComponent implements OnInit, OnChanges {

  @Input()
  petOwner: any;

  genderText: string;
  @ViewChild("createPetOwnerModal")
  createPetOwnerModal: ModalComponent;
  @ViewChild("createPetModal")
  createPetModal:ModalComponent;

  @ViewChild("updatePetOwnerModal")
  updatePetOwnerModal: ModalComponent;


  @Output()
  petSelected = new EventEmitter<Pet>();
  @Output()
  petOwnerCleared = new EventEmitter();
  @Output()
  petOwnerCreated = new EventEmitter<any>();
  @Output()
  petOwnerUpdated = new EventEmitter<any>();

  @Output()
  petCreated=new EventEmitter<any>();
  @Output()
  petUpdated=new EventEmitter<any>();


  constructor() {
  }

  ngOnInit() {
  }

  onModifyOwnerButtonClicked() {
    this.updatePetOwnerModal.open();
  }

  onCreateNewPetButtonClicked() {
    this.createPetModal.open();
  }

  onPetSelected(event: Pet) {
    this.petSelected.emit(event);
  }

  onCreateNewOwnerButtonClicked() {
    this.createPetOwnerModal.open();
  }

  onClearPetButtonClicked() {
    this.genderText = '';
    this.petOwnerCleared.emit();
  }

  onPetOwnerCreated(event: any) {
    this.petOwnerCreated.emit(event);
    this.createPetOwnerModal.dismiss();
  }

  onPetOwnerUpdated(event: any) {

    this.petOwnerUpdated.emit(event);
    this.updatePetOwnerModal.dismiss();
  }

  ngOnChanges(changes: SimpleChanges): void {
    if (changes['petOwner'] && this.petOwner) {
      this.genderText = GenderEnum[this.petOwner.gender];
    }
  }

  onPetCreated(event: any) {
    this.petCreated.emit(event);
    this.createPetModal.dismiss();
  }
  onPetUpdated(event: any) {
    this.petUpdated.emit(event);
  }
}
