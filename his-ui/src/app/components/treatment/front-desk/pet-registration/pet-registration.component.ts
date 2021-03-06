import {Component, OnInit, ViewChild} from '@angular/core';
import {ModalComponent} from "ng2-bs3-modal/ng2-bs3-modal";
import {Pet} from "../../../../dto/pet.model";
import {PetOwner} from "../../../../dto/pet-owner.model";
import {PetOwnerService} from "../../../../services/treatment/pet-owner.service";
import {OperationEnum} from "../../../../enums/operation.enum";
import {DepartmentService} from "../../../../services/treatment/department.service";
import {Department} from "../../../../dto/department.model";
import {TreatmentEmployeeService} from "../../../../services/treatment/treatment-employee.service";
import {TreatmentEmployeeModel} from "../../../../dto/treatment.employee.model";
import {RegistrationService} from "../../../../services/treatment/registration.service";
import {TreatmentRegistrationModel} from "../../../../dto/treatment.registration.model";

@Component({
  selector: 'app-pet-registration',
  templateUrl: './pet-registration.component.html',
  styleUrls: ['./pet-registration.component.css']
})
export class PetRegistrationComponent implements OnInit {

  @ViewChild('registrationResultModal') registrationResultModal:ModalComponent;

  ownerModalTitle: string;
  ownerOperationMode: OperationEnum;

  petModalTitle: string;
  petOperationMode: OperationEnum;

  findByPetOwnerNameText: string;
  selectedPet: Pet = {};
  newPetOwner: PetOwner = {}
  newPet: Pet = {};

  currentPetOwner: PetOwner = {};
  departments: Department[];
  selectedDepartment: Department = {};
  selectedDoctor: TreatmentEmployeeModel = {};
  availableDoctors: TreatmentEmployeeModel[];
  returnedRegistration:TreatmentRegistrationModel={};

  constructor(public petOwnerService: PetOwnerService, public departmentService: DepartmentService, public treatmentEmployeeService: TreatmentEmployeeService, public registrationService:RegistrationService) {
  }

  ngOnInit() {
    this.selectedDepartment.name = "请选择科室";
    this.selectedDoctor.name = "请先选择科室";
    this.departmentService.getDepartments().subscribe(r => {
      this.departments = r;
    })
  }


  onCreatePetOwnerButtonClicked(createPetOwnerModal: ModalComponent) {
    this.ownerModalTitle = "新建主人";
    this.ownerOperationMode = OperationEnum.CREATE;
    this.newPetOwner = {};
    createPetOwnerModal.open();

  }

  onModifyOwnerButtonClicked(createPetOwnerModal: ModalComponent) {
    this.ownerModalTitle = "修改主人信息";
    this.ownerOperationMode = OperationEnum.UPDATE;
    this.newPetOwner = this.currentPetOwner;
    createPetOwnerModal.open();

  }

  onCreateNewPetButtonClicked(createPetModal: ModalComponent) {
    this.petModalTitle = "新增宠物";
    this.petOperationMode = OperationEnum.CREATE;
    this.newPet = {};
    createPetModal.open();
  }

  onUpdatePetButtonClicked(createPetModal: ModalComponent) {
    this.petModalTitle = "修改宠物信息";
    this.petOperationMode = OperationEnum.UPDATE;
    this.newPet = this.selectedPet;
    createPetModal.open();
  }

  onCreatePetOwnerModalClosed() {
    this.petOwnerService.operatePetOwner(this.newPetOwner, this.ownerOperationMode).subscribe(r => {
      this.currentPetOwner = r;
    });
  }

  onCreatePetModalClosed() {
    this.newPet.petOwner = {};
    this.newPet.petOwner.id = this.currentPetOwner.id;
    this.petOwnerService.operatePet(this.newPet, this.petOperationMode).subscribe(r => {
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
    this.selectedDoctor = {};
    this.selectedDoctor.name = "请先选择科室";
    this.selectedDepartment = {};
    this.selectedDepartment.name = "请选择科室";
    this.availableDoctors=[];
    this.selectedPet={};
    this.currentPetOwner={};
  }

  onRemovePetButtonClicked(pet: Pet) {
    pet.petOwner = {};
    pet.petOwner.id = this.currentPetOwner.id;
    this.petOwnerService.deletePet(pet).subscribe(r => {
      this.currentPetOwner = r;
    });
  }

  onRowClicked(pet: Pet) {
    this.selectedPet = pet;
  }

  isRowSelected(pet: Pet): boolean {
    return this.selectedPet == pet;
  }


  setSelectedDepartment(department: Department) {
    this.selectedDepartment = department;
    this.treatmentEmployeeService.findByDepartment(department.id).subscribe(r => {
      this.availableDoctors = r;
      this.selectedDoctor.name = "请选择医生";
    })
  }

  setSelectedDoctor(doctor: TreatmentEmployeeModel) {
    this.selectedDoctor = doctor;
  }

  onRegistrationButtonClicked(confirmRegistrationModal:ModalComponent) {
    confirmRegistrationModal.open();
  }

  onConfirmRegistrationModalClosed() {
    this.registrationService.createRegistration(this.selectedDoctor.id,1,this.selectedPet.id).subscribe(r=>{
      this.returnedRegistration=r;
      this.registrationResultModal.open();
    });
  }

  onRegistrationResultModalClosed() {

  }
}
