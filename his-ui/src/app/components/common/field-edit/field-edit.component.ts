import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-field-edit',
  templateUrl: './field-edit.component.html',
  styleUrls: ['./field-edit.component.css']
})
export class FieldEditComponent implements OnInit {

  @Input()
  value: number = 0.00;
  @Output()
  valueChanged: EventEmitter<number> = new EventEmitter();
  @Input()
  hint: string;

  formModel: FormGroup;

  constructor(private fb: FormBuilder) {

  }

  isViewMode: boolean = true;
  isMouseEntered: boolean = false;

  ngOnInit() {
    this.initForm();
    if (this.value == null)
      if (this.hint !== null)
        this.formModel.controls['price'].setValue(this.hint);
      else
        this.formModel.controls['price'].setValue("价格未设置");
    else
      this.formModel.controls['price'].setValue(this.value);
  }

  private initForm() {
    this.formModel = this.fb.group({
      'price': ['', [Validators.required, Validators.pattern(/^\d*\.?\d*$/)]]
    })
  }

  onMouseEnter() {
    this.isMouseEntered = true;

  }

  onMouseLeave() {
    this.isMouseEntered = false;
  }

  onSaveClicked() {
    this.isViewMode = true;
    this.value = this.formModel.controls['price'].value;
    this.valueChanged.emit(this.value);
  }

  previousValue: any;

  onEditClicked() {
    this.isViewMode = false;
    this.previousValue = this.formModel.controls['price'].value;
  }

  onCancelClicked() {
    this.isViewMode = true;
    this.formModel.controls['price'].setValue(this.previousValue);
  }
}
