import {Component, OnInit, ViewChild} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {PetOwnerService} from "../../../core/services/treatment/pet-owner.service";
import {BehaviorSubject, Observable} from "rxjs";
import {PetOwner} from "../../models/pet-owner.model";
import {ModalComponent} from "ng2-bs3-modal/ng2-bs3-modal";
import {Pet} from "../../models/pet.model";
import {Department} from "../../models/department.model";
import {TreatmentEmployeeModel} from "../../models/treatment.employee.model";
import {TreatmentDepartmentService} from "../../../core/services/treatment/treatment-department.service";
import {TreatmentEmployeeService} from "../../../core/services/treatment/treatment-employee.service";
import {RegistrationService} from "../../../core/services/treatment/registration.service";
import {OperationEnum} from "../../../core/enums/operation.enum";
import {InpatientManagementService} from "../../../core/services/treatment/inpatient-management.service";
import {InpatientManagement} from "../../../core/models/treatment/model.component";

@Component({
  selector: 'app-inpatient-record-create-update',
  templateUrl: './inpatient-record-create-update.component.html',
  styleUrls: ['./inpatient-record-create-update.component.css']
})
export class InpatientRecordCreateUpdateComponent implements OnInit {

  formModel: FormGroup;
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
  @ViewChild("findByNameResultModal") findByNameResultModal: ModalComponent;
  registrationResultSubject = new BehaviorSubject<any>({});
  registrationResult$ = this.registrationResultSubject.asObservable();

  constructor(private petOwnerService: PetOwnerService,
              private treatmentDepartmentService: TreatmentDepartmentService,
              private treatmentEmployeeService: TreatmentEmployeeService,
              private inpatientManagementService:InpatientManagementService,
              private fb: FormBuilder
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
    this.initForm();
  }

  onQueryClicked(event) {

    if (event.memberId) {
    } else if (event.treatmentId) {
    } else if (event.ownerName) {
      this.petOwnerService.findPetOwnerByName(event.ownerName).subscribe(r => {
        if (r.length == 1) {
          this.petOwnerSubject.next(r[0]);
        } else if (r.length > 1) {
          this.petOwnerList = r;
          this.findByNameResultModal.open();
        }
      });
    }
  }

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

  onPetInpatientRequested(event) {

    const request:InpatientManagement={
      'petUuid': event.pet.id,
      'requestDoctorUuid': event.doctor.id,
    };

    this.inpatientManagementService.createInpatientRecord(request).subscribe(r => {
      this.registrationResultSubject.next(r);
    });
  }

  private initForm() {

    this.formModel = this.fb.group({
      'petUuid': ['', [Validators.required]],
      'petName': ['', [Validators.required]],
      'requestDoctor': ['', [Validators.required]],
      'requestDoctorUuid': ['', [Validators.required]],
      'reasonToInpatient': ['', [Validators.required]],
      'petStatus': ['', [Validators.required]]
    })
  }

  onSubmit() {

  }

}
