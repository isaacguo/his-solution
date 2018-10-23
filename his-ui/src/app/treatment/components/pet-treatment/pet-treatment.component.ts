import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {TreatmentCase} from "../../models/treatment-case.model";

@Component({
  selector: 'app-pet-treatment',
  templateUrl: './pet-treatment.component.html',
  styleUrls: ['./pet-treatment.component.css']
})
export class PetTreatmentComponent implements OnInit {


  @Input()
  treatmentCases:TreatmentCase[]
  @Output()
  treatmentCaseCreate=new EventEmitter();

  constructor() { }

  ngOnInit() {
  }

  onConfirmDeleteModalClosed()
  {}


  onCreateTreatmentCase() {
    this.treatmentCaseCreate.emit();
  }
}
