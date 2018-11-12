import {Component, OnDestroy, OnInit} from '@angular/core';
import {Observable} from "rxjs/Observable";
import {TreatmentCase} from "../../models/treatment-case.model";
import {TreatmentCaseService} from "../../../core/services/treatment/treatment-case.service";
import {ActivatedRoute, Router} from "@angular/router";
import {TreatmentRegistrationModel} from "../../models/treatment.registration.model";
import {Pet} from "../../models/pet.model";
import {RegistrationService} from "../../../core/services/treatment/registration.service";
import {PetService} from "../../../core/services/treatment/pet.service";
import {PetOwnerService} from "../../../core/services/treatment/pet-owner.service";
import {BehaviorSubject} from "rxjs/BehaviorSubject";
import {combineLatest} from "rxjs/observable/combineLatest";
import {Subscription} from "rxjs/Subscription";

@Component({
  selector: 'app-pet-treatment-container',
  templateUrl: './pet-treatment-container.component.html',
  styleUrls: ['./pet-treatment-container.component.css']
})
export class PetTreatmentContainerComponent implements OnInit, OnDestroy {

  registrationSubject = new BehaviorSubject<TreatmentRegistrationModel>({});
  registration$ = this.registrationSubject.asObservable();
  registrationSubscription: Subscription;


  treatmentCaseChangedSubject = new BehaviorSubject<boolean>(false);
  treatmentCaseChanged$ = this.treatmentCaseChangedSubject.asObservable();
  treatmentCases$: Observable<TreatmentCase[]>;
  unClosedTreatmentCases$: Observable<TreatmentCase[]>;
  closedTreatmentCases$: Observable<TreatmentCase[]>;

  selectedTreatmentCaseSubject = new BehaviorSubject<TreatmentCase>({});
  selectedTreatmentCase$: Observable<TreatmentCase> = this.selectedTreatmentCaseSubject.asObservable();

  petSubject = new BehaviorSubject<Pet>({});
  pet$: Observable<Pet> = this.petSubject.asObservable();
  petSubscription: Subscription;


  isLoadingSubject=new BehaviorSubject<boolean>(true);
  isLoading$=this.isLoadingSubject.asObservable();

  constructor(private treatmentCaseService: TreatmentCaseService,
              private route: ActivatedRoute,
              private router: Router,
              private petOwnerService: PetOwnerService,
              private petService: PetService,
              private registrationService: RegistrationService) {

  }

  ngOnInit() {

    this.registrationSubscription = this.route.parent.params.mergeMap(p => this.registrationService.readOne(p['registrationId']))
      .subscribe(r => {
        this.registrationSubject.next(r);
      });

    this.petSubscription = this.registration$.mergeMap(r => {
      if (r && r.pet && r.pet.id)
        return this.petService.findOne(r.pet.id);
      else
        return Observable.of({});
    }).subscribe(p => this.petSubject.next(p));


    this.treatmentCases$ = combineLatest(this.treatmentCaseChanged$, this.pet$).mergeMap(([event, p]) => {
      if (p && p.id)
        return this.treatmentCaseService.findAllByPetId(p.id)
      else
        return [];
    }).shareReplay(2);

    this.unClosedTreatmentCases$ = this.treatmentCases$.map(cases => cases.filter(tc => !tc.caseClosed)).do(()=>{this.isLoadingSubject.next(false)});

    this.closedTreatmentCases$ = this.treatmentCases$.map(cases => cases.filter(tc => tc.caseClosed));
  }

  onTreatmentCaseCreated() {
    this.pet$.take(1).mergeMap(p => this.treatmentCaseService.create({pet: p}))
      .do(() => this.treatmentCaseChangedSubject.next(true))
      .subscribe(t =>
        this.router.navigate([t.id], {relativeTo: this.route}));
  }

  onTreatmentCaseSelected($treatmentCase: TreatmentCase) {
    this.selectedTreatmentCaseSubject.next($treatmentCase);
    this.router.navigate([$treatmentCase.id], {relativeTo: this.route});
  }

  ngOnDestroy(): void {

    this.registrationSubscription.unsubscribe();
    this.petSubscription.unsubscribe();
  }
}
