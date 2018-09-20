import {Component, OnInit, ViewChild} from '@angular/core';
import {ModalComponent} from "ng2-bs3-modal/ng2-bs3-modal";
import {OperationEnum} from "../../../../core/enums/operation.enum";
import {Pet} from "../../../models/pet.model";
import {PetOwner} from "../../../models/pet-owner.model";
import {Department} from "../../../models/department.model";
import {TreatmentEmployeeModel} from "../../../models/treatment.employee.model";
import {TreatmentRegistrationModel} from "../../../models/treatment.registration.model";
import {PetOwnerService} from "../../../../core/services/treatment/pet-owner.service";
import {DepartmentService} from "../../../../core/services/treatment/department.service";
import {RegistrationService} from "../../../../core/services/treatment/registration.service";
import {TreatmentEmployeeService} from "../../../../core/services/treatment/treatment-employee.service";

@Component({
  selector: 'app-pet-registration',
  templateUrl: './pet-registration.component.html',
  styleUrls: ['./pet-registration.component.css']
})
export class PetRegistrationComponent implements OnInit {

  @ViewChild("findByNameResultModal") findByNameResultModal: ModalComponent;
  @ViewChild('registrationResultModal') registrationResultModal: ModalComponent;

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
  returnedRegistration: TreatmentRegistrationModel = {};

  constructor(public petOwnerService: PetOwnerService, public departmentService: DepartmentService, public treatmentEmployeeService: TreatmentEmployeeService, public registrationService: RegistrationService) {
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

  findByNameResult: any[] = [];

  onFindPetOwnerButtonClicked() {
    if (this.findByPetOwnerNameText) {
      this.petOwnerService.findPetOwnerByName(this.findByPetOwnerNameText).subscribe(r => {
        if (r.length == 1) {
          this.currentPetOwner = r[0];
        }
        else if (r.length > 1) {
          this.findByNameResult = r;
          this.findByNameResultModal.open();
        }
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
    this.availableDoctors = [];
    this.selectedPet = {};
    this.currentPetOwner = {};
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
    this.treatmentEmployeeService.findByDepartmentAndCanBeRegisteredIsTrue(department.depId).subscribe(r => {
      this.availableDoctors = r;
      this.selectedDoctor.name = "请选择医生";
    })
  }

  setSelectedDoctor(doctor: TreatmentEmployeeModel) {
    this.selectedDoctor = doctor;
  }

  onRegistrationButtonClicked(confirmRegistrationModal: ModalComponent) {
    confirmRegistrationModal.open();
  }

  onConfirmRegistrationModalClosed() {
    this.registrationService.createRegistration(this.selectedDoctor.id, 1, this.selectedPet.id, null, "WAITING").subscribe(r => {
      this.returnedRegistration = r;
      this.registrationResultModal.open();
    });
  }

  onRegistrationResultModalClosed() {

  }

  onFindByNameResultModalClosed() {

  }

  onPetOwnerSelected(queryResult: any) {
    this.currentPetOwner = queryResult;
  }


  isOwnerSelected(queryResult: any): boolean {
    return this.currentPetOwner == queryResult;
  }

  onFindByNameResultModalDismissed() {
    this.currentPetOwner = null;
    this.selectedPet = null;
  }
}
