import {Component} from '@angular/core';
import {TreatmentCase} from "../../models/treatment-case.model";
import {Observable} from "rxjs/Observable";
import {TreatmentCaseService} from "../../../core/services/treatment/treatment-case.service";
import {ActivatedRoute} from "@angular/router";
import {PetOwner} from "../../models/pet-owner.model";

@Component({
  selector: 'app-customer-service-treatment-case-info-conatiner',
  templateUrl: './customer-service-treatment-case-info-container.component.html',
  styleUrls: ['./customer-service-treatment-case-info-container.component.css']
})
export class CustomerServiceTreatmentCaseInfoContainerComponent  {

  treatmentCase: Observable<TreatmentCase>;
  petOwner: Observable<PetOwner>;

  constructor(private treatmentCaseService: TreatmentCaseService,
              private route: ActivatedRoute) {

    this.treatmentCase = this.route.parent.params.mergeMap(r => this.treatmentCaseService.readOne(r['treatmentCaseId']));
    this.petOwner = this.route.parent.params.mergeMap(r => this.treatmentCaseService.getPetOwnerInfoByTreatmentCaseId(r['treatmentCaseId']));

  }

}
