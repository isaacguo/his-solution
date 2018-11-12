import {ChangeDetectionStrategy, Component, OnDestroy, OnInit} from '@angular/core';
import {Observable} from "rxjs/Observable";
import {Pet} from "../../models/pet.model";
import {PetOwnerService} from "../../../core/services/treatment/pet-owner.service";
import {RegistrationService} from "../../../core/services/treatment/registration.service";
import {ActivatedRoute, Router} from "@angular/router";
import {TreatmentRegistrationModel} from "../../models/treatment.registration.model";
import {PetService} from "../../../core/services/treatment/pet.service";
import {PetOwner} from "../../models/pet-owner.model";
import {BehaviorSubject} from "rxjs/BehaviorSubject";
import {Subject} from "rxjs/Subject";
import {Subscription} from "rxjs/Subscription";

@Component({
  selector: 'app-pet-info-container',
  templateUrl: './pet-info-container.component.html',
  styleUrls: ['./pet-info-container.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class PetInfoContainerComponent implements OnInit, OnDestroy {

  petOwner$: Observable<PetOwner>;
  pet$: Observable<Pet>;
  registrationSubject = new BehaviorSubject<TreatmentRegistrationModel>({});
  registration$ = this.registrationSubject.asObservable();

  subscription: Subscription;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private petOwnerService: PetOwnerService,
    private petService: PetService,
    private registrationService: RegistrationService) {

    this.subscription = route.parent.params.mergeMap(p =>
      this.registrationService.readOne(p['registrationId']))
      .subscribe(r => this.registrationSubject.next(r))


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

  }

  ngOnInit() {
  }


  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }
}
