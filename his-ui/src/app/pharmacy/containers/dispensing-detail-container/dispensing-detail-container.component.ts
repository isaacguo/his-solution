import {Component, OnDestroy, OnInit} from '@angular/core';
import {Observable} from "rxjs/Observable";
import {MedicineInfo} from "../../models/medicine-info.model";
import {PetOwnerService} from "../../../core/services/treatment/pet-owner.service";
import {PetService} from "../../../core/services/treatment/pet.service";
import {PharmacyPrescriptionService} from "../../../core/services/pharmacy/pharmacy-prescription.service";
import {ActivatedRoute, Router} from "@angular/router";
import {BehaviorSubject, Subscription} from "rxjs";
import {Pet} from "../../../treatment/models/pet.model";
import {PetOwner} from "../../../treatment/models/pet-owner.model";

@Component({
  selector: 'app-dispensing-detail-container',
  templateUrl: './dispensing-detail-container.component.html',
  styleUrls: ['./dispensing-detail-container.component.css']
})
export class DispensingDetailContainerComponent implements OnInit, OnDestroy {


  prescriptionSubject = new BehaviorSubject<any>({});
  prescription$ = this.prescriptionSubject.asObservable();
  prescriptionSubscription: Subscription;

  pet$: Observable<Pet>;
  petOwner$: Observable<PetOwner>;

  constructor(
    private petOwnerService: PetOwnerService,
    private petService: PetService,
    private pharmacyPrescriptionService: PharmacyPrescriptionService,
    private route: ActivatedRoute,
    private router: Router
  ) {

    this.prescriptionSubscription = this.route.params.mergeMap(p => this.pharmacyPrescriptionService.readOne(p['prescriptionId']))
      .subscribe(r => {
        this.prescriptionSubject.next(r);
      });


    this.pet$ = this.prescription$.mergeMap(r => {
      if (r && r.petUuid)
        return this.petService.findByUuid(r.petUuid);
      else
        return Observable.of({});
    });


  }

  ngOnInit() {
  }

  onMedicineDispensed() {

  }

  ngOnDestroy(): void {
    this.prescriptionSubscription.unsubscribe();
  }
}
