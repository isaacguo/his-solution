import {ChangeDetectionStrategy, Component, OnInit, ViewChild} from '@angular/core';
import {BehaviorSubject, Observable, Subscription} from "rxjs";
import {TreatmentRegistrationModel} from "../../models/treatment.registration.model";
import {Pet} from "../../models/pet.model";
import {PetOwner} from "../../models/pet-owner.model";
import {ModalComponent} from "ng2-bs3-modal/ng2-bs3-modal";
import {PetOwnerService} from "../../../core/services/treatment/pet-owner.service";
import {PetService} from "../../../core/services/treatment/pet.service";
import {RegistrationService} from "../../../core/services/treatment/registration.service";
import {TreatmentCaseService} from "../../../core/services/treatment/treatment-case.service";
import {ActivatedRoute, Router} from "@angular/router";
import {combineLatest} from "rxjs/observable/combineLatest";
import {PharmacyPrescriptionService} from "../../../core/services/pharmacy/pharmacy-prescription.service";

@Component({
  selector: 'app-treatment-prescriptions-container',
  templateUrl: './treatment-prescriptions-container.component.html',
  styleUrls: ['./treatment-prescriptions-container.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class TreatmentPrescriptionsContainerComponent implements OnInit {

  registrationSubject = new BehaviorSubject<TreatmentRegistrationModel>({});
  registration$ = this.registrationSubject.asObservable();
  registrationSubscription: Subscription;
  petSubject = new BehaviorSubject<Pet>({});
  pet$: Observable<Pet> = this.petSubject.asObservable();
  petSubscription: Subscription;
  petOwner$: Observable<PetOwner>;
  @ViewChild("createMedicalTestsModal") createMedicalTestsModal: ModalComponent;

  actionChangedSubject = new BehaviorSubject<boolean>(false);
  actionChanged$ = this.actionChangedSubject.asObservable();


  selectedPrescriptionSubject = new BehaviorSubject<any>({});
  selectedPrescription$: Observable<any> = this.selectedPrescriptionSubject.asObservable();

  todayPrescriptions$: Observable<any[]>;
  historyPrescriptions$: Observable<any[]>;

  isLoadingSubject = new BehaviorSubject<boolean>(true);
  isLoading$ = this.isLoadingSubject.asObservable();

  constructor(
    private petOwnerService: PetOwnerService,
    private petService: PetService,
    private registrationService: RegistrationService,
    private treatmentCaseService: TreatmentCaseService,
    private pharmacyPrescriptionService: PharmacyPrescriptionService,
    private route: ActivatedRoute,
    private router: Router) {
  }

  ngOnInit() {

    this.registrationSubscription = this.route.parent.params.mergeMap(p => this.registrationService.readOne(p['registrationId']))
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

    this.todayPrescriptions$ = combineLatest(this.actionChanged$, this.pet$).mergeMap(([event, p]) => {
      this.isLoadingSubject.next(false)
      if (p && p.id)
        return this.pharmacyPrescriptionService.findByPetUuidToday(p.uuid)
      else
        return Observable.of([]);
    });
    this.historyPrescriptions$ = combineLatest(this.actionChanged$, this.pet$).mergeMap(([event, p]) => {
      if (p && p.id)
        return this.pharmacyPrescriptionService.findByPetUuidHistory(p.uuid)
      else
        return Observable.of([]);
    });
  }

  onCreatePrescriptionClicked() {


    combineLatest(this.pet$.take(1), this.petOwner$.take(1)).mergeMap(([pet, petOwner]) => {
      return this.pharmacyPrescriptionService.create(
        {
          'petOwnerUuid': petOwner.uuid,
          'petUuid':pet.uuid
        }
      )
    }).subscribe(() => {
      this.actionChangedSubject.next(true);
    })
  }

  onPrescriptionSelected($event: any) {
    this.selectedPrescriptionSubject.next($event);
    this.router.navigate([$event.id], {relativeTo: this.route});
  }

}
