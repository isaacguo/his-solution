import {ChangeDetectionStrategy, Component, OnInit, ViewChild} from '@angular/core';
import {ModalComponent} from "ng2-bs3-modal/ng2-bs3-modal";
import {TreatmentCaseService} from "../../../core/services/treatment/treatment-case.service";
import {ActivatedRoute, Router} from "@angular/router";
import {PetOwnerService} from "../../../core/services/treatment/pet-owner.service";
import {PetService} from "../../../core/services/treatment/pet.service";
import {RegistrationService} from "../../../core/services/treatment/registration.service";
import {BehaviorSubject, Observable, Subscription} from "rxjs";
import {TreatmentRegistrationModel} from "../../models/treatment.registration.model";
import {Pet} from "../../models/pet.model";
import {PetOwner} from "../../models/pet-owner.model";
import {MedicalTestReportService} from "../../../core/services/medical-test/medical-test-report.service";
import {MedicalTestReportTemplateService} from "../../../core/services/medical-test/medical-test-report-template.service";
import {combineLatest} from "rxjs/observable/combineLatest";
import {MedicalTestReport} from "../../../medical-test/models/medical-test-report.model";

@Component({
  selector: 'app-treatment-medical-test-container',
  templateUrl: './treatment-medical-test-container.component.html',
  styleUrls: ['./treatment-medical-test-container.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class TreatmentMedicalTestContainerComponent implements OnInit {


  registrationSubject = new BehaviorSubject<TreatmentRegistrationModel>({});
  registration$ = this.registrationSubject.asObservable();
  registrationSubscription: Subscription;
  petSubject = new BehaviorSubject<Pet>({});
  pet$: Observable<Pet> = this.petSubject.asObservable();
  petSubscription: Subscription;
  petOwner$: Observable<PetOwner>;
  @ViewChild("createMedicalTestsModal") createMedicalTestsModal: ModalComponent;

  medicalTestReportChangedSubject = new BehaviorSubject<boolean>(false);
  medicalTestReportChanged$ = this.medicalTestReportChangedSubject.asObservable();

  selectedMedicalTestReportSubject = new BehaviorSubject<MedicalTestReport>({});
  selectedMedicalTest$: Observable<MedicalTestReport> = this.selectedMedicalTestReportSubject.asObservable();

  medicaTestReport$: Observable<MedicalTestReport[]>;
  todayMedicalTestReports$: Observable<MedicalTestReport[]>;
  historyMedicalTestReports$: Observable<MedicalTestReport[]>;

  isLoadingSubject = new BehaviorSubject<boolean>(true);
  isLoading$ = this.isLoadingSubject.asObservable();

  constructor(
    private petOwnerService: PetOwnerService,
    private petService: PetService,
    private registrationService: RegistrationService,
    private treatmentCaseService: TreatmentCaseService,
    private medicalTestReportService: MedicalTestReportService,
    private medicalTestReportTemplateService: MedicalTestReportTemplateService,
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

    this.todayMedicalTestReports$ = combineLatest(this.medicalTestReportChanged$, this.pet$).mergeMap(([event, p]) => {
      this.isLoadingSubject.next(false)
      if (p && p.id)
        return this.medicalTestReportService.findByPetUuidToday(p.uuid)
      else
        return Observable.of([]);
    });
    this.historyMedicalTestReports$ = combineLatest(this.medicalTestReportChanged$, this.pet$).mergeMap(([event, p]) => {
      if (p && p.id)
        return this.medicalTestReportService.findByPetUuidHistory(p.uuid)
      else
        return Observable.of([]);
    });
  }

  onCreateMedicalTestClicked() {
    this.createMedicalTestsModal.open();
  }

  onGenerateMedicalTestReport($event: any) {
    this.createMedicalTestsModal.dismiss();
    this.medicalTestReportService.createReports($event).subscribe(()=>{
      this.medicalTestReportChangedSubject.next(true);
    });
  }

  onMedicalTestSelected($event: any) {
    this.selectedMedicalTestReportSubject.next($event);
    this.router.navigate([$event.uuid], {relativeTo: this.route});

  }
}
