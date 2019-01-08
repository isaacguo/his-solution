import {Component, OnDestroy, OnInit} from '@angular/core';
import {BehaviorSubject, Observable, Subject, Subscription} from "rxjs";
import {FormArray, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {minLengthArray} from "../../../utilities/form-utilities";
import {TreatmentRegistrationModel} from "../../models/treatment.registration.model";
import {Pet} from "../../models/pet.model";
import {PetOwner} from "../../models/pet-owner.model";
import {PetOwnerService} from "../../../core/services/treatment/pet-owner.service";
import {PetService} from "../../../core/services/treatment/pet.service";
import {RegistrationService} from "../../../core/services/treatment/registration.service";
import {ActivatedRoute, Router} from "@angular/router";
import {combineLatest} from "rxjs/observable/combineLatest";

@Component({
  selector: 'app-treatment-prescription-detail-container',
  templateUrl: './treatment-prescription-detail-container.component.html',
  styleUrls: ['./treatment-prescription-detail-container.component.css']
})
export class TreatmentPrescriptionDetailContainerComponent implements OnInit, OnDestroy {


  registrationSubject = new BehaviorSubject<TreatmentRegistrationModel>({});
  registration$ = this.registrationSubject.asObservable();
  registrationSubscription: Subscription;
  petSubject = new BehaviorSubject<Pet>({});
  pet$: Observable<Pet> = this.petSubject.asObservable();
  petSubscription: Subscription;
  petOwner$: Observable<PetOwner>;

  formModelSubscription: Subscription;


  formModel$ = new Subject<FormGroup>();
  formModel: FormGroup;

  constructor(private fb: FormBuilder,
              private router: Router,
              private route: ActivatedRoute,
              private petOwnerService: PetOwnerService,
              private petService: PetService,
              private registrationService: RegistrationService
  ) {

    this.initForm();

    this.registrationSubscription = this.route.parent.parent.params.mergeMap(p => this.registrationService.readOne(p['registrationId']))
      .subscribe(r => {
        this.registrationSubject.next(r);
      });

    this.pet$ = this.registration$.mergeMap(r => {
      if (r && r.pet && r.pet.id)
        return this.petService.findOne(r.pet.id);
      else
        return Observable.of({});
    });

    this.petOwner$ = this.registration$.mergeMap(r => {
      if (r && r.pet && r.pet.id)
        return this.petService.findPetOwner({id: r.pet.id})
      else
        return Observable.of({});
    });

    this.formModelSubscription = combineLatest(this.registration$, this.pet$, this.petOwner$).subscribe(([registration, pet, petOwner]) => {
      if (registration && registration.doctor ) {
        this.formModel.controls['doctorName'].setValue(registration.doctor.name)
        this.formModel.controls['doctorUuid'].setValue(registration.doctor.uuid)
      }
      this.formModel.controls['petName'].setValue(pet.name)
      this.formModel.controls['petOwnerName'].setValue(petOwner.name)
      this.formModel.controls['petUuid'].setValue(pet.uuid)
      this.formModel.controls['petOwnerUuid'].setValue(petOwner.uuid)
      this.formModel$.next(this.formModel);
    })
  }

  ngOnInit() {

  }

  onMedicineSelected($event: any) {
    this.addPrescription($event);
  }

  onSubmitPrescription() {

  }


  addPrescription(prescription: any) {
    const control = <FormArray>this.formModel.controls['prescriptions'];
    control.push(this.initPrescription(prescription));

    this.formModel$.next(this.formModel);
  }

  private initPrescription(prescription: any) {
    return this.fb.group({
      'uuid': [prescription.uuid, Validators.required],
      'name': [prescription.name, Validators.required],
      'specification': [prescription.specification, Validators.required],
      'unit': [prescription.unit, Validators.required],
      'amount':[1, Validators.required]
    })
  }


  private initForm() {
    this.formModel = this.fb.group({
      'id': [],
      'petName': ['', Validators.required],
      'petOwnerName': ['', Validators.required],
      'doctorName': ['', Validators.required],
      'petUuid': ['', Validators.required],
      'petOwnerUuid': ['', Validators.required],
      'doctorUuid': ['', Validators.required],
      'prescriptions': this.fb.array([], minLengthArray(1)),
    })
  }

  ngOnDestroy(): void {
    this.formModelSubscription.unsubscribe();
    this.registrationSubscription.unsubscribe();
  }

  onRemovePrescription($event: number) {
    console.log($event);
    const control = <FormArray>this.formModel.controls['prescriptions'];
    control.removeAt($event);
    this.formModel$.next(this.formModel);
  }
}
