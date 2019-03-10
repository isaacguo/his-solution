import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {AbstractItemSelectableTableComponent} from "../../../shared/components/abstract-item-selectable-table/abstract-item-selectable-table.component";
import {AbstractControl, FormArray, FormBuilder, FormGroup} from "@angular/forms";
import {PrescriptionStatusEnum} from "../../../core/enums/prescription-status.enum";

@Component({
  selector: 'app-treatment-prescription-detail',
  templateUrl: './treatment-prescription-detail.component.html',
  styleUrls: ['./treatment-prescription-detail.component.css']
})
export class TreatmentPrescriptionDetailComponent extends AbstractItemSelectableTableComponent<any> implements OnInit {

  @Input()
  formModel: FormGroup;
  @Output()
  removePrescription = new EventEmitter<number>();
  @Output()
  amountChanged = new EventEmitter<any>();

  @Output()
  submitPrescription = new EventEmitter();


  get prescriptionsData() {
    if (this.formModel) {
      return <FormArray>this.formModel.get('items');
    } else
      return null;
  }

  constructor(
    private fb: FormBuilder
  ) {
    super();
  }

  ngOnInit() {
  }

  onRemoveButtonClicked(i: number) {
    this.removePrescription.emit(i);
  }

  onValueChanged($event: number, index: number, count: string) {
    this.amountChanged.emit({'index': index, 'field': count, 'amount': $event})
  }

  isPrescriptionStillUnSubmitted() {
    if (this.formModel) {
      return this.formModel.controls['status'].value === PrescriptionStatusEnum.UNSUBMITTED;
    } else {
      return false;
    }
  }

}
