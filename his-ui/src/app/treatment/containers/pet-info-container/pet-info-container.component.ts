import {ChangeDetectionStrategy, Component, OnInit} from '@angular/core';
import {Observable} from "rxjs/Observable";
import {Pet} from "../../models/pet.model";
import {PetOwnerService} from "../../../core/services/treatment/pet-owner.service";
import {RegistrationService} from "../../../core/services/treatment/registration.service";
import {ActivatedRoute, Router} from "@angular/router";
import {TreatmentRegistrationModel} from "../../models/treatment.registration.model";
import {PetService} from "../../../core/services/treatment/pet.service";
import {PetOwner} from "../../models/pet-owner.model";

@Component({
  selector: 'app-pet-info-container',
  templateUrl: './pet-info-container.component.html',
  styleUrls: ['./pet-info-container.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class PetInfoContainerComponent implements OnInit {

  petOwner$: Observable<PetOwner>;
  pet$: Observable<Pet>;
  registration$: Observable<TreatmentRegistrationModel>;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private petOwnerService: PetOwnerService,
    private petService: PetService,
    private registrationService: RegistrationService) {

    this.registration$ = route.parent.params.mergeMap(p => this.registrationService.readOne(p['registrationId'])).shareReplay(2);
    this.pet$ = this.registration$.mergeMap(r => this.petService.findOne(r.pet.id));
    this.petOwner$ = this.registration$.mergeMap(r => this.petService.findPetOwner({id:r.pet.id}));


  }

  ngOnInit() {
  }

}
