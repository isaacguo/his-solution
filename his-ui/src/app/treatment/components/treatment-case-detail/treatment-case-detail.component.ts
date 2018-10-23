import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {TreatmentCase} from "../../models/treatment-case.model";
import {FormBuilder, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-treatment-case-detail',
  templateUrl: './treatment-case-detail.component.html',
  styleUrls: ['./treatment-case-detail.component.css']
})
export class TreatmentCaseDetailComponent implements OnInit {

  @Input()
  treatmentCase: TreatmentCase;
  @Output()
  treatmentCaseSaved = new EventEmitter<any>();

  treatmentCaseInfoModel: FormGroup;

  constructor(private fb: FormBuilder) {
  }

  private initForm() {
    this.treatmentCaseInfoModel = this.fb.group({
      'id': [''],
      'petOwnerDescription': [''],
      'clinicSituation': [''],
      'doctorDiagnose': [''],
      'doctorAdvice': ['']
    });
  }

  ngOnInit() {
  }

  onSaveTreatmentCaseBasicInfo() {
    this.treatmentCaseSaved.emit(this.treatmentCaseInfoModel.value);
  }
}
