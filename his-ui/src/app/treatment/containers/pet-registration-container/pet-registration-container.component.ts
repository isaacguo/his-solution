import {ChangeDetectionStrategy, Component, OnDestroy, OnInit, ViewChild} from '@angular/core';
import {PetOwnerService} from "../../../core/services/treatment/pet-owner.service";
import {PetOwner} from "../../models/pet-owner.model";
import {Observable} from "rxjs/Observable";
import {BehaviorSubject} from "rxjs/BehaviorSubject";
import {ModalComponent} from "ng2-bs3-modal/ng2-bs3-modal";
import {Pet} from "../../models/pet.model";
import {OperationEnum} from "../../../core/enums/operation.enum";
import {Department} from "../../models/department.model";
import {TreatmentDepartmentService} from "../../../core/services/treatment/treatment-department.service";
import {TreatmentEmployeeModel} from "../../models/treatment.employee.model";
import {TreatmentEmployeeService} from "../../../core/services/treatment/treatment-employee.service";
import {RegistrationService} from "../../../core/services/treatment/registration.service";

@Component({
  selector: 'app-pet-registration-container',
  templateUrl: './pet-registration-container.component.html',
  styleUrls: ['./pet-registration-container.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class PetRegistrationContainerComponent implements OnInit {

  petOwnerSubject = new BehaviorSubject<PetOwner>({});
  petOwner$ = this.petOwnerSubject.asObservable();
  petOwnerList = [];

  selectedPetSubject = new BehaviorSubject<Pet>({});
  selectedPet$ = this.selectedPetSubject.asObservable();


  departments$: Observable<Department[]>; //= this.departmentsSubject.asObservable();


  selectedDepartmentSubject = new BehaviorSubject<Department>({} as Department);
  selectedDepartment$ = this.selectedDepartmentSubject.asObservable();

  doctors$: Observable<TreatmentEmployeeModel[]>;

  selectedDoctorSubject = new BehaviorSubject<TreatmentEmployeeModel>({} as TreatmentEmployeeModel);
  selectedDoctor$ = this.selectedDoctorSubject.asObservable();

  registrationFee$: Observable<string>;

  constructor(private petOwnerService: PetOwnerService,
              private treatmentDepartmentService: TreatmentDepartmentService,
              private treatmentEmployeeService: TreatmentEmployeeService,
              private registrationService:RegistrationService
              ) {


    this.doctors$ = this.selectedDepartment$.mergeMap((department) => {
      if (department.depId)
        return treatmentEmployeeService.findByDepartmentAndCanBeRegisteredIsTrue(department.depId)
      else
        return Observable.of([]);
    }).do(() =>
      this.selectedDoctorSubject.next({}));

    this.departments$ = this.selectedPet$.mergeMap((p) => {
      if (p.id)
        return treatmentDepartmentService.loadData();
      else
        return Observable.of([]);
    });
  }


  ngOnInit() {


  }


  onQueryClicked(event) {

    if (event.memberId) {
    }
    else if (event.treatmentId) {
    }
    else if (event.ownerName) {
      this.petOwnerService.findPetOwnerByName(event.ownerName).subscribe(r => {
        if (r.length == 1) {
          this.petOwnerSubject.next(r[0]);
        }
        else if (r.length > 1) {
          this.petOwnerList = r;
          this.findByNameResultModal.open();
        }
      });
    }
  }

  @ViewChild("findByNameResultModal") findByNameResultModal: ModalComponent;

  onPetOwnerSelected(event: PetOwner) {
    this.petOwnerSubject.next(event);
  }

  onPetSelected(event: Pet) {
    this.selectedPetSubject.next(event);
  }

  onPetOwnerCleared() {
    this.petOwnerSubject.next({});
    this.selectedPetSubject.next({});
  }

  onPetOwnerCreated(event) {
    this.petOwnerService.operatePetOwner(event, OperationEnum.CREATE).subscribe(r => {
      this.petOwnerSubject.next(r);
    });
  }

  onPetOwnerUpdated(event) {
    this.petOwnerService.operatePetOwner(event, OperationEnum.UPDATE).subscribe(r => {
      this.petOwnerSubject.next(r);
    });

  }

  onPetCreated(event) {
    this.petOwnerSubject.asObservable().take(1).subscribe(
      (owner) => {
        this.petOwnerService.operatePet({...event, petOwner: {id: owner.id}}, OperationEnum.CREATE).subscribe(r => {
          this.petOwnerSubject.next(r);
        });
      });
  }

  onPetUpdated(event) {
    this.petOwnerSubject.asObservable().take(1).subscribe(
      (owner) => {
        this.petOwnerService.operatePet({...event, petOwner: {id: owner.id}}, OperationEnum.UPDATE).subscribe(r => {
          this.petOwnerSubject.next(r);
        });
      });
  }


  onDepartmentSelected(event) {
    this.selectedDepartmentSubject.next(event);
  }

  onDoctorSelected(event) {
    this.selectedDoctorSubject.next(event);
  }

  registrationResultSubject=new BehaviorSubject<any>({});
  registrationResult$=this.registrationResultSubject.asObservable();
  onPetRegistered(event) {
    this.registrationService.createRegistration(event.doctor.id, 1, event.pet.id, null, "WAITING", event.doctor.uuid).subscribe(r => {
      this.registrationResultSubject.next(r);
    });
  }
}
