import {Component, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {TreatmentCaseService} from "../../../../../services/treatment/treatment-case.service";

@Component({
  selector: 'app-pet-treatment-detail',
  templateUrl: './pet-treatment-detail.component.html',
  styleUrls: ['./pet-treatment-detail.component.css']
})
export class PetTreatmentDetailComponent implements OnChanges {


  ngOnChanges(changes: SimpleChanges): void {
    this.loadData();
  }

  @Input()
  treatmentCase: any;
  detailedTreatmentCase: any[] = [];

  constructor(private treatmentCaseService: TreatmentCaseService) {
  }

  private loadData() {
    if (this.treatmentCase != null)
      this.treatmentCaseService.readOne(this.treatmentCase.id).subscribe(r => {
        this.detailedTreatmentCase = r;
        console.log(this.detailedTreatmentCase);
      });
  }
}
