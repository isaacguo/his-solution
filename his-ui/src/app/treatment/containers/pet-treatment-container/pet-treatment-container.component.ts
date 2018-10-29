import {Component, OnInit} from '@angular/core';
import {Observable} from "rxjs/Observable";
import {TreatmentCase} from "../../models/treatment-case.model";
import {TreatmentCaseService} from "../../../core/services/treatment/treatment-case.service";
import {ActivatedRoute, Router} from "@angular/router";
import {TreatmentRegistrationModel} from "../../models/treatment.registration.model";
import {PetOwner} from "../../models/pet-owner.model";
import {Pet} from "../../models/pet.model";
import {RegistrationService} from "../../../core/services/treatment/registration.service";
import {PetService} from "../../../core/services/treatment/pet.service";
import {PetOwnerService} from "../../../core/services/treatment/pet-owner.service";
import {BehaviorSubject} from "rxjs/BehaviorSubject";
import {combineLatest} from "rxjs/observable/combineLatest";

@Component({
  selector: 'app-pet-treatment-container',
  templateUrl: './pet-treatment-container.component.html',
  styleUrls: ['./pet-treatment-container.component.css']
})
export class PetTreatmentContainerComponent implements OnInit {

  treatmentCaseChangedSubject = new BehaviorSubject<boolean>(false);
  treatmentCaseChanged$ = this.treatmentCaseChangedSubject.asObservable();
  treatmentCases$: Observable<TreatmentCase[]>;
  unClosedTreatmentCases$: Observable<TreatmentCase[]>;
  closedTreatmentCases$: Observable<TreatmentCase[]>;

  selectedTreatmentCaseSubject=new BehaviorSubject<TreatmentCase>({});
  selectedTreatmentCase$: Observable<TreatmentCase>=this.selectedTreatmentCaseSubject.asObservable();

  petOwner$: Observable<PetOwner>;
  petSubject = new BehaviorSubject<Pet>({});
  pet$: Observable<Pet> = this.petSubject.asObservable();
  registration$: Observable<TreatmentRegistrationModel>;

  constructor(private treatmentCaseService: TreatmentCaseService,
              private route: ActivatedRoute,
              private router: Router,
              private petOwnerService: PetOwnerService,
              private petService: PetService,
              private registrationService: RegistrationService) {


    this.registration$ = route.parent.params.mergeMap(p => this.registrationService.readOne(p['registrationId']))
    this.registration$.mergeMap(r => this.petService.findOne(r.pet.id)).subscribe(p => this.petSubject.next(p));
    //this.petOwner$ = this.registration$.mergeMap(r => this.petService.findPetOwner({id:r.pet.id}));
    this.treatmentCases$ = combineLatest(this.treatmentCaseChanged$, this.pet$).mergeMap(([event, p]) => {
      if (p.id)
        return this.treatmentCaseService.findAllByPetId(p.id)
      else
        return [];
    }).shareReplay(2);
    this.unClosedTreatmentCases$ = this.treatmentCases$.map(cases => cases.filter(tc => !tc.caseClosed));
    this.closedTreatmentCases$ = this.treatmentCases$.map(cases => cases.filter(tc => tc.caseClosed));
  }

  ngOnInit() {
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
}