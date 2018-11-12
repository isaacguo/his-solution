import {Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges} from '@angular/core';
import {TreatmentCase} from "../../models/treatment-case.model";
import {FormBuilder, FormGroup} from "@angular/forms";
import {TreatmentCaseStatusEnum} from "../../../core/enums/treatment-case-status.enum";

@Component({
  selector: 'app-treatment-case-detail',
  templateUrl: './treatment-case-detail.component.html',
  styleUrls: ['./treatment-case-detail.component.css']
})
export class TreatmentCaseDetailComponent implements OnInit, OnChanges {

  @Input()
  treatmentCase: TreatmentCase;


  @Output()
  treatmentCaseSaved = new EventEmitter<any>();


  treatmentCaseInfoModel: FormGroup;

  constructor(private fb: FormBuilder) {
    this.initForm();
  }

  private initForm() {
    this.treatmentCaseInfoModel = this.fb.group({
      'id': [''],
      'treatmentDate': [''],
      'createdDate': [''],
      'lastModifiedDateTime': [''],
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

  ngOnChanges(changes: SimpleChanges): void {
    if (changes['treatmentCase'] && this.treatmentCase)
      this.treatmentCaseInfoModel.patchValue(this.treatmentCase);
  }

  isTreatmentCaseFinished() {
    if (this.treatmentCase)
      return this.treatmentCase.treatmentCaseStatus === TreatmentCaseStatusEnum.FINISHED;
  }

  onSaveClicked() {
    this.treatmentCaseSaved.emit(this.treatmentCaseInfoModel.value);
  }


}
