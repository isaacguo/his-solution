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
import {PharmacyPrescriptionService} from "../../../core/services/pharmacy/pharmacy-prescription.service";
import {PopupModalBundle} from "../../../shared/models/popup-modal-bundle.model";
import {PrescriptionStatusEnum} from "../../../core/enums/prescription-status.enum";

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
  petOwner$: Observable<PetOwner>;

  prescription$: Observable<any>;

  formModelSubscription: Subscription;


  formModel$ = new Subject<FormGroup>();
  formModel: FormGroup;

  prescriptionChangedSubject = new BehaviorSubject<boolean>(false);
  prescriptionChanged$ = this.prescriptionChangedSubject.asObservable();

  constructor(private fb: FormBuilder,
              private router: Router,
              private route: ActivatedRoute,
              private petOwnerService: PetOwnerService,
              private petService: PetService,
              private registrationService: RegistrationService,
              private pharmacyPrescriptionService: PharmacyPrescriptionService
  ) {

    this.initForm();

    this.registrationSubscription = this.route.parent.parent.params.mergeMap(p => this.registrationService.readOne(p['registrationId']))
      .subscribe(r => {
        this.registrationSubject.next(r);
      });

    this.prescription$ = combineLatest(this.prescriptionChanged$, this.route.params).mergeMap(([change, p]) => {
      return this.pharmacyPrescriptionService.readOne(p['prescriptionId'])
    })


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


    this.formModelSubscription = combineLatest(this.registration$, this.pet$, this.petOwner$, this.prescription$).subscribe(([registration, pet, petOwner, prescription]) => {
      if (registration && registration.doctor) {
        this.formModel.controls['doctorName'].setValue(registration.doctor.name)
        this.formModel.controls['doctorUuid'].setValue(registration.doctor.uuid)
      }

      this.formModel.controls['id'].setValue(prescription.id);
      this.formModel.controls['uuid'].setValue(prescription.uuid);
      this.formModel.controls['petName'].setValue(pet.name)
      this.formModel.controls['petOwnerName'].setValue(petOwner.name)
      this.formModel.controls['petUuid'].setValue(pet.uuid)
      this.formModel.controls['petOwnerUuid'].setValue(petOwner.uuid)

      this.formModel.controls['status'].setValue(prescription.status)

      this.clearFormArray(<FormArray>this.formModel.controls['items'])


      prescription.items.forEach(r => {
        this.addPrescription(this.inflatePrescriptionItem(r));
      })

      this.formModel$.next(this.formModel);
    })
  }


  clearFormArray(formArray: FormArray) {
    while (formArray.length !== 0) {
      formArray.removeAt(0)
    }
  }

  ngOnInit() {

  }

  onMedicineSelected($event: any) {
    this.addPrescription(this.initPrescription($event));
  }


  onSavePrescription() {
    this.pharmacyPrescriptionService.update(this.formModel.controls['uuid'].value, this.formModel.value).subscribe(() => {

      this.popupBundleSubject.next({
        title: '成功',
        body: '<h4>保存成功</h4>',
        hasConfirmButton: true,
        confirmButtonText: "确定",
      })

      this.prescriptionChangedSubject.next(true);
    })
  }

  onModalClosed($event) {
    if ($event.closePrescription) {
      this.pharmacyPrescriptionService.submitPrescription(this.formModel.value)
        .subscribe(() =>
          this.prescriptionChangedSubject.next(true)
        )
    }
  }

  addPrescription(prescriptionFormGroup: any) {
    const control = <FormArray>this.formModel.controls['items'];
    control.push(prescriptionFormGroup);

    this.formModel$.next(this.formModel);
  }


  private inflatePrescriptionItem(prescription: any) {
    return this.fb.group({
      'id': [prescription.id],
      'uuid': [prescription.uuid],
      'inventoryItemUuid': [prescription.inventoryItemUuid, Validators.required],
      'name': [prescription.name, Validators.required],
      'specification': [prescription.specification, Validators.required],
      'unit': [prescription.unit, Validators.required],
      'amount': [prescription.amount, Validators.required],
    })
  }

  private initPrescription(prescription: any) {
    return this.fb.group({
      'inventoryItemUuid': [prescription.uuid, Validators.required],
      'name': [prescription.name, Validators.required],
      'specification': [prescription.specification, Validators.required],
      'unit': [prescription.unit, Validators.required],
      'amount': [1, Validators.required]
    })
  }


  private initForm() {
    this.formModel = this.fb.group({
      'id': [],
      'uuid': ['', Validators.required],
      'petName': ['', Validators.required],
      'petOwnerName': ['', Validators.required],
      'doctorName': ['', Validators.required],
      'petUuid': ['', Validators.required],
      'petOwnerUuid': ['', Validators.required],
      'doctorUuid': ['', Validators.required],
      'items': this.fb.array([], minLengthArray(1)),
      'status': [],
    })
  }

  ngOnDestroy(): void {
    this.formModelSubscription.unsubscribe();
    this.registrationSubscription.unsubscribe();
  }

  onRemovePrescription($event: number) {
    const control = <FormArray>this.formModel.controls['items'];
    control.removeAt($event);
    this.formModel$.next(this.formModel);
  }


  popupBundleSubject = new BehaviorSubject<PopupModalBundle>({});
  bundle$: Observable<PopupModalBundle> = this.popupBundleSubject.asObservable();


  onSubmitPrescription() {

    this.popupBundleSubject.next({
      title: '请确定',
      body: '<h4>是否要提交处方?</h4>\n<h4 class="label label-danger isaac-font-medium ">提交处方后，无法再次修改</h4>',
      hasConfirmButton: true,
      confirmButtonText: "确定",
      hasCancelButton: true,
      cancelButtonText: "取消",
      payload: {'closePrescription': true}
    })
  }

  isPrescriptionStillUnSubmitted() {
    if (this.formModel) {
      return this.formModel.controls['status'].value === PrescriptionStatusEnum.UNSUBMITTED;
    } else {
      return false;
    }
  }

  onAmountChanged($event: any) {
    (<FormGroup> (<FormArray>this.formModel.get('items')).at($event.index)).controls['amount'].setValue($event.amount);
  }

  get prescriptionsData() {
    if (this.formModel) {
      return <FormArray>this.formModel.get('items');
    } else
      return null;
  }
}
