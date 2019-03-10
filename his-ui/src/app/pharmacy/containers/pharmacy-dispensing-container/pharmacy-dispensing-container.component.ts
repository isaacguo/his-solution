import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {PetOwnerService} from "../../../core/services/treatment/pet-owner.service";
import {PetService} from "../../../core/services/treatment/pet.service";
import {PharmacyPrescriptionService} from "../../../core/services/pharmacy/pharmacy-prescription.service";
import {BehaviorSubject, Observable, Subscription} from "rxjs";
import {PageableParams} from "../../../core/models/pageable-params.model";
import {PrescriptionStatusEnum} from "../../../core/enums/prescription-status.enum";
import {Pet} from "../../../treatment/models/pet.model";
import {PetOwner} from "../../../treatment/models/pet-owner.model";

@Component({
  selector: 'app-pharmacy-dispensing-container',
  templateUrl: './pharmacy-dispensing-container.component.html',
  styleUrls: ['./pharmacy-dispensing-container.component.css']
})
export class PharmacyDispensingContainerComponent implements OnInit {

  pageInfoSubject = new BehaviorSubject<PageableParams>({size: 15, status: PrescriptionStatusEnum.PAID, page: 0});
  pageInfo$ = this.pageInfoSubject.asObservable();
  pageData$: Observable<any>;
  selectedStatus$: Observable<string>;


  selectedPrescriptionSubject = new BehaviorSubject<any>({});
  selectedPrescription$: Observable<any> = this.selectedPrescriptionSubject.asObservable();


  prescriptionChangedSubject = new BehaviorSubject<boolean>(false);
  prescriptionChanged$ = this.prescriptionChangedSubject.asObservable();

  petSubject = new BehaviorSubject<Pet>({});
  pet$: Observable<Pet> = this.petSubject.asObservable();
  petOwner$: Observable<PetOwner>;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private petOwnerService: PetOwnerService,
    private petService: PetService,
    private pharmacyPrescriptionService: PharmacyPrescriptionService
  ) {



    this.pageData$ = this.pageInfo$.mergeMap(page => this.pharmacyPrescriptionService.findAllPrescriptionsByStatusOnPage(page.page, page.status, page.size));
  }

  ngOnInit() {
  }

  onPageChanged(event) {
    this.pageInfoSubject.next(event);
  }

  itemSelected($event: any) {
    this.selectedPrescriptionSubject.next($event);
    this.router.navigate([$event.id],{relativeTo:this.route});
  }
}
