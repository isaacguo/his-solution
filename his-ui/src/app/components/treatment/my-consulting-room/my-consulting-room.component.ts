import {Component, OnInit} from '@angular/core';
import {RegistrationService} from "../../../services/treatment/registration.service";
import {TreatmentRegistrationModel} from "../../../dto/treatment/treatment.registration.model";
import {PetOwnerService} from "../../../services/treatment/pet-owner.service";
import {DepartmentService} from "../../../services/treatment/department.service";
import {TreatmentEmployeeService} from "../../../services/treatment/treatment-employee.service";
import {PetInfo, PetService} from "../../../services/treatment/pet.service";
import {PetOperationRequest} from "../../../dto/treatment/pet.operation.request";
import {RegistrationStatusEnum} from "../../../enums/registration-status.enum";
import {EmploymentStatusEnum} from "../../../enums/employment.status.enum";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {IMyDateModel, IMyDpOptions} from "mydatepicker";

@Component({
  selector: 'app-my-consulting-room',
  templateUrl: './my-consulting-room.component.html',
  styleUrls: ['./my-consulting-room.component.css']
})
export class MyConsultingRoomComponent implements OnInit {

  myRegistrations: any[];
  selectedRegistration: any;

  searchFormModel: FormGroup;

  constructor(private fb: FormBuilder, public petOwnerService: PetOwnerService, public petService: PetService, public departmentService: DepartmentService, public treatmentEmployeeService: TreatmentEmployeeService, public registrationService: RegistrationService) {

  }

  ngOnInit() {

    this.initSearchFormModel();
    this.loadData();
  }

  private loadData() {
    this.selectedRegistration=null;
    this.registrationService.findMyRegistrationToday().subscribe(r => {
      this.petService.clearPetInfo();
      if (this.searchFormModel.controls["includeDone"].value)
        this.myRegistrations = r;
      else {
        let myRegistrationsList = r.filter(e => {
          return RegistrationStatusEnum[e.registrationStatus] === RegistrationStatusEnum.WAITING ||
            RegistrationStatusEnum[e.registrationStatus] === RegistrationStatusEnum.CURING;
        })
        this.myRegistrations = myRegistrationsList;
      }
    })
  }

  onRowClicked(registration: any) {
    this.selectedRegistration = registration;
    let request: PetOperationRequest = {};
    request.id = registration.pid;
    this.petService.findPetOwner(request).subscribe(r => {

      let petInfo = new PetInfo({'id': this.selectedRegistration.pid}, r, this.selectedRegistration);
      this.petService.setPetInfo(petInfo);

    });
  }

  isRowSelected(registration: any): boolean {
    return this.selectedRegistration == registration;
  }

  getRegistrationStatusString(reg: RegistrationStatusEnum): string {
    return RegistrationStatusEnum[reg];
  }

  isWaiting(reg: RegistrationStatusEnum): boolean {
    return RegistrationStatusEnum[reg];
  }


  getRegistrationStatusList(): [string, string][] {
    let arr: any;

    arr = Object.keys(RegistrationStatusEnum).map(k => {
      return [k, RegistrationStatusEnum[k as any]]
    });
    return arr;

  }

  selectedRegistrationStatusText


  private initSearchFormModel() {
    this.searchFormModel = this.fb.group({
      'memberId': [''],
      'treatmentId': [''],
      'ownerName': [''],
      'petName': [''],
      'mobilePhoneNumber': [''],
      'startDate': [''],
      'endDate': [''],
      'includeDone': [false]
    })
  }

  public myDatePickerOptions: IMyDpOptions = {
    dateFormat: 'yyyy-mm-dd',
  };

  onRegistrationQueryClicked() {


  }

  onDateChanged(control: string, event: IMyDateModel) {
    if (event.formatted !== '') {
      this.searchFormModel.controls[control].setValue(event.formatted);
    }
    else {
      this.searchFormModel.controls[control].setValue("");
    }
  }

  onIncludeDoneChanged(event) {
    this.loadData();
  }
}
