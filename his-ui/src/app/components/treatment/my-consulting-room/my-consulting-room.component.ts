import {Component, OnInit} from '@angular/core';
import {RegistrationService} from "../../../services/treatment/registration.service";
import {TreatmentRegistrationModel} from "../../../dto/treatment/treatment.registration.model";
import {PetOwnerService} from "../../../services/treatment/pet-owner.service";
import {DepartmentService} from "../../../services/treatment/department.service";
import {TreatmentEmployeeService} from "../../../services/treatment/treatment-employee.service";
import {PetInfo, PetService} from "../../../services/treatment/pet.service";
import {PetOperationRequest} from "../../../dto/treatment/pet.operation.request";

@Component({
  selector: 'app-my-consulting-room',
  templateUrl: './my-consulting-room.component.html',
  styleUrls: ['./my-consulting-room.component.css']
})
export class MyConsultingRoomComponent implements OnInit {

  myRegistrations: TreatmentRegistrationModel[];
  selectedRegistration: TreatmentRegistrationModel;

  constructor(public petOwnerService: PetOwnerService, public petService: PetService, public departmentService: DepartmentService, public treatmentEmployeeService: TreatmentEmployeeService, public registrationService: RegistrationService) {

  }

  ngOnInit() {

    this.registrationService.findMyRegistrationToday().subscribe(r => {
      this.myRegistrations = r;
    })
    //this.petService.clearPetInfo();
  }

  onRowClicked(registration: TreatmentRegistrationModel) {
    this.selectedRegistration = registration;
    let request: PetOperationRequest = {};
    request.id = registration.pet.id;
    this.petService.findPetOwner(request).subscribe(r => {

      let petInfo = new PetInfo(this.selectedRegistration.pet, r);
      this.petService.setPetInfo(petInfo);

    });
  }

  isRowSelected(registration: TreatmentRegistrationModel): boolean {
    return this.selectedRegistration == registration;
  }


}
