import {ChangeDetectionStrategy, Component, EventEmitter, Input, OnInit, Output, ViewChild} from '@angular/core';
import {ModalComponent} from "ng2-bs3-modal/ng2-bs3-modal";
import {Department} from "../../models/department.model";
import {Pet} from "../../models/pet.model";
import {PetOwner} from "../../models/pet-owner.model";

@Component({
  selector: 'app-pet-registration-panel',
  templateUrl: './pet-registration-panel.component.html',
  styleUrls: ['./pet-registration-panel.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class PetRegistrationPanelComponent implements OnInit {


  @Input()
  selectedPetOwner: PetOwner;
  @Input()
  selectedPet: Pet;
  @Input()
  departments: Department[];
  @Input()
  doctors: any[];
  @Input()
  registrationFee: any;


  _registrationResult: any
  @Input()
  set registrationResult(result: any) {
    if (result && result.indexOfDay) {
      this._registrationResult = result;
      this.registrationResultModal.open();
    }
  }


  @Input()
  selectedDepartment: Department;
  @Input()
  selectedDoctor: any;


  @Output()
  departmentSelected = new EventEmitter<any>();
  @Output()
  doctorSelected = new EventEmitter<any>();
  @Output()
  petRegistered = new EventEmitter<any>();

  @ViewChild("confirmRegistrationModal")
  confirmRegistrationModal: ModalComponent;

  @ViewChild("registrationResultModal")
  registrationResultModal: ModalComponent;


  constructor() {

  }


  ngOnInit() {


  }

  setSelectedDepartment(department) {
    this.departmentSelected.emit(department);
  }

  setSelectedDoctor(doctor) {
    this.doctorSelected.emit(doctor);
  }

  onRegistrationButtonClicked() {
    this.confirmRegistrationModal.open();
  }

  onConfirmRegistrationModalClosed() {
    this.petRegistered.emit({
      'petOwner': this.selectedPetOwner,
      'pet': this.selectedPet,
      'doctor': this.selectedDoctor
    });
  }
}
