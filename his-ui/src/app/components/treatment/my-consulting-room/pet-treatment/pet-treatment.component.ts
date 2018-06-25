import {Component, OnDestroy, OnInit} from '@angular/core';
import {MedicalTestReportService} from "../../../../services/medical-test/medical-test-report.service";
import {PetInfo, PetService} from "../../../../services/treatment/pet.service";
import {PetOwner} from "../../../../dto/treatment/pet-owner.model";
import {Pet} from "../../../../dto/treatment/pet.model";
import {Subscription} from "rxjs/Subscription";
import {TreatmentCaseService} from "../../../../services/treatment/treatment-case.service";
import {TreatmentCase} from "../../../../dto/treatment/treatment-case.model";

@Component({
  selector: 'app-pet-treatment',
  templateUrl: './pet-treatment.component.html',
  styleUrls: ['./pet-treatment.component.css']
})
export class PetTreatmentComponent implements OnInit, OnDestroy {


  petInfo: PetInfo;
  petInfoChangeSubscription: Subscription;


  treatmentCases:any[]=[];

  ngOnDestroy(): void {
    this.petInfoChangeSubscription.unsubscribe();
  }

  constructor(private treatmentCaseService: TreatmentCaseService, private medicalTestReportService: MedicalTestReportService, private petService: PetService) {
    this.petInfoChangeSubscription = petService.petInfoChange.subscribe(
      newPetInfo =>
        this.petInfo = newPetInfo);
  }

  ngOnInit() {
    this.loadData();
  }

  private loadData() {
    this.treatmentCaseService.findAllByPetId(this.petInfo.pet.id).subscribe(r=>{
      this.treatmentCases=r;
    });
  }

  onCreateTreatmentCase() {

    let treatmentCase={pet:this.petInfo.pet};
    this.treatmentCaseService.create(treatmentCase).subscribe(r=>{
      this.loadData();

    });
  }
}
