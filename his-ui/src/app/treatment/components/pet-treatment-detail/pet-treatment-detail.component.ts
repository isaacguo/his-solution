import {Component, Input, OnInit} from '@angular/core';
import {TreatmentCase} from "../../models/treatment-case.model";

@Component({
  selector: 'app-pet-treatment-detail',
  templateUrl: './pet-treatment-detail.component.html',
  styleUrls: ['./pet-treatment-detail.component.css']
})
export class PetTreatmentDetailComponent implements OnInit {

  @Input()
  treatmentCase: TreatmentCase;

  constructor() {
  }

  ngOnInit() {
  }

}
