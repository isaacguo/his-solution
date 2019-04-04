import {Component, EventEmitter, Input, OnInit, Output, ViewChild} from '@angular/core';
import {PetOwner} from "../../models/pet-owner.model";
import {Pet} from "../../models/pet.model";
import {Department} from "../../models/department.model";
import {ModalComponent} from "ng2-bs3-modal/ng2-bs3-modal";

@Component({
  selector: 'app-inpatient-record-request',
  templateUrl: './inpatient-record-request.component.html',
  styleUrls: ['./inpatient-record-request.component.css']
})
export class InpatientRecordRequestComponent implements OnInit {


  @Input()
  selectedPetOwner: PetOwner;
  @Input()
  selectedPet: Pet;
  @Input()
  departments: Department[];
  @Input()
  doctors: any[];


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
  petInpatientRequested = new EventEmitter<any>();

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
    this.petInpatientRequested.emit({
      'petOwner': this.selectedPetOwner,
      'pet': this.selectedPet,
      'doctor': this.selectedDoctor
    });
  }

}
