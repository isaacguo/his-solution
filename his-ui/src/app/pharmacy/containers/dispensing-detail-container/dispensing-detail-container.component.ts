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
import {PopupModalBundle} from "../../../shared/models/popup-modal-bundle.model";
import {combineLatest} from "rxjs/observable/combineLatest";

@Component({
  selector: 'app-dispensing-detail-container',
  templateUrl: './dispensing-detail-container.component.html',
  styleUrls: ['./dispensing-detail-container.component.css']
})
export class DispensingDetailContainerComponent implements OnInit, OnDestroy {


  operationChangedSubject = new BehaviorSubject<boolean>(true);
  operationChanged$ = this.operationChangedSubject.asObservable();

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

    this.prescriptionSubscription = combineLatest(this.operationChanged$, this.route.params).mergeMap(([op, params]) => {
      return this.pharmacyPrescriptionService.readOne(params['prescriptionId'])
    })
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
    this.prescription$.take(1).mergeMap((p) => {
      return this.pharmacyPrescriptionService.medicineDispensed(p);
    })
      .subscribe(() => {

        this.popupBundleSubject.next({
          title: '信息',
          body: '药品已发放',
          hasConfirmButton: true,
          confirmButtonText: "确定",
        })

        this.operationChangedSubject.next(true);
      });
  }

  popupBundleSubject = new BehaviorSubject<PopupModalBundle>({});
  bundle$: Observable<PopupModalBundle> = this.popupBundleSubject.asObservable();

  ngOnDestroy(): void {
    this.prescriptionSubscription.unsubscribe();
  }

  onWithdrawMedicine() {
    this.prescription$.take(1).mergeMap((p) => {
      return this.pharmacyPrescriptionService.withdrawMedicine(p);
    })
      .subscribe(() => {

        this.popupBundleSubject.next({
          title: '信息',
          body: '药品已从库房领取',
          hasConfirmButton: true,
          confirmButtonText: "确定",
        })

        this.operationChangedSubject.next(true);
      });

  }
}
