import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {AbstractItemSelectableTableComponent} from "../../../shared/components/abstract-item-selectable-table/abstract-item-selectable-table.component";
import {FormBuilder} from "@angular/forms";

@Component({
  selector: 'app-treatment-prescription-detail',
  templateUrl: './treatment-prescription-detail.component.html',
  styleUrls: ['./treatment-prescription-detail.component.css']
})
export class TreatmentPrescriptionDetailComponent extends AbstractItemSelectableTableComponent<any> implements OnInit {


  @Output()
  submitPrescription = new EventEmitter();


  constructor(
    private fb: FormBuilder
  ) {
    super();
  }

  ngOnInit() {
  }

  onSubmitPrescription() {
    this.submitPrescription.emit();
  }
}
