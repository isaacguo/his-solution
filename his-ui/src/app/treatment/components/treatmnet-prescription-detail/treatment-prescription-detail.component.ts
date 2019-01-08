import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {AbstractItemSelectableTableComponent} from "../../../shared/components/abstract-item-selectable-table/abstract-item-selectable-table.component";
import {AbstractControl, FormArray, FormBuilder, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-treatment-prescription-detail',
  templateUrl: './treatment-prescription-detail.component.html',
  styleUrls: ['./treatment-prescription-detail.component.css']
})
export class TreatmentPrescriptionDetailComponent extends AbstractItemSelectableTableComponent<any> implements OnInit {

  @Input()
  formModel: FormGroup;
  @Output()
  removePrescription=new EventEmitter<number>();

  @Output()
  submitPrescription = new EventEmitter();


  get prescriptionsData() {
    if (this.formModel)
      return <FormArray>this.formModel.get('items');
    else
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

  onValueChanged($event: number, prescription: AbstractControl, count: string) {


  }

}
