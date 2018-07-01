import {Component, OnDestroy, OnInit, ViewChild} from '@angular/core';
import {MedicalTestReportService} from "../../../../services/medical-test/medical-test-report.service";
import {PetInfo, PetService} from "../../../../services/treatment/pet.service";
import {Subscription} from "rxjs/Subscription";
import {TreatmentCaseService} from "../../../../services/treatment/treatment-case.service";
import {ModalComponent} from "ng2-bs3-modal/ng2-bs3-modal";
import {RegistrationService} from "../../../../services/treatment/registration.service";
import {RegistrationStatusEnum} from "../../../../enums/registration-status.enum";
import {OperationEnum} from "../../../../enums/operation.enum";

@Component({
  selector: 'app-pet-treatment',
  templateUrl: './pet-treatment.component.html',
  styleUrls: ['./pet-treatment.component.css']
})
export class PetTreatmentComponent implements OnInit, OnDestroy {


  @ViewChild("confirmDeleteModal")
  confirmDeleteModal: ModalComponent;

  petInfo: PetInfo;
  petInfoChangeSubscription: Subscription;


  treatmentCases: any[] = [];

  ngOnDestroy(): void {
    this.petInfoChangeSubscription.unsubscribe();
  }

  constructor(private treatmentCaseService: TreatmentCaseService,
              private medicalTestReportService: MedicalTestReportService,
              private petService: PetService,
              private registrationService: RegistrationService) {
    this.petInfoChangeSubscription = petService.petInfoChange.subscribe(
      newPetInfo =>
        this.petInfo = newPetInfo);
  }

  ngOnInit() {
    this.loadData();
  }

  private loadData() {
    this.treatmentCaseService.findAllByPetId(this.petInfo.pet.id).subscribe(r => {
      this.treatmentCases = r;
    });
  }

  onCreateTreatmentCase() {

    let treatmentCase = {pet: this.petInfo.pet};
    this.treatmentCaseService.create(treatmentCase).subscribe(r => {
      this.loadData();

    });
  }

  selectedTreatmentCase: any;

  onRowClicked(treatmentCase: any) {
    this.selectedTreatmentCase = treatmentCase;
  }

  isRowSelected(treatmentCase: any): boolean {
    return this.selectedTreatmentCase == treatmentCase;
  }

  onRemoveTreatmentCaseButtonClicked(treatmentCase: any) {
    this.confirmDeleteModal.open();
  }

  onUpdateTreatmentCaseButtonClicked(treatmentCase: any) {

  }

  onConfirmDeleteModalClosed() {
    let tid = this.selectedTreatmentCase.id;
    this.selectedTreatmentCase = null;
    this.treatmentCaseService.deleteOne(tid).subscribe(r => {
        this.loadData();
      }
    );
  }

  isWaiting(): boolean {
    return RegistrationStatusEnum[this.petInfo.registration.registrationStatus] === RegistrationStatusEnum.WAITING;
  }

  isCuring(): boolean {
    return RegistrationStatusEnum[this.petInfo.registration.registrationStatus] === RegistrationStatusEnum.CURING;
  }

  onTreatmentStarted() {
    this.updateStatus("CURING");
  }

  private updateStatus(status: string) {
    this.registrationService.updateStatus(this.petInfo.registration.rid, status).subscribe(r => {
      let newReg = this.petInfo.registration;
      newReg.registrationStatus = r;
      let petInfo = new PetInfo({'id': this.petInfo.pet.id}, this.petInfo.petOwner, newReg);
      this.petService.setPetInfo(petInfo);
    });
  }

  onTreatmentFinished() {

    this.updateStatus("FINISHED");
  }
}
