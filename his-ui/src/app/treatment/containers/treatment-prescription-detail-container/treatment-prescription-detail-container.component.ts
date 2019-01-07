import { Component, OnInit } from '@angular/core';
import {Observable} from "rxjs";
import {FormArray, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {minLengthArray} from "../../../utilities/form-utilities";

@Component({
  selector: 'app-treatment-prescription-detail-container',
  templateUrl: './treatment-prescription-detail-container.component.html',
  styleUrls: ['./treatment-prescription-detail-container.component.css']
})
export class TreatmentPrescriptionDetailContainerComponent implements OnInit {

  formModel: FormGroup;
  constructor(private fb: FormBuilder) { }

  ngOnInit() {
    this.initForm();
  }

  onMedicineSelected($event: any) {

  }

  onSubmitPrescription($event: any) {
    
  }

  get prescriptionsData() {
    return <FormArray>this.formModel.get('prescriptions');
  }

  onRemoveButtonClicked(i: number) {
    const control = <FormArray>this.formModel.controls['prescriptions'];
    control.removeAt(i);
  }
  addPrescription(prescription:any) {
    const control = <FormArray>this.formModel.controls['prescriptions'];
    control.push(this.initPrescription(prescription));
  }
  private initPrescription(prescription:any) {
    return this.fb.group({
      'uuid': [prescription.uuid, Validators.required],
      'name': [prescription.name, Validators.required],
      'specification': [prescription.specification, Validators.required],
      'unit': [prescription.unit, Validators.required],
    })
  }


  private initForm() {
    this.formModel = this.fb.group({
      'id': [],
      'petUuid': ['', Validators.required],
      'petOwnerUuid': ['', Validators.required],
      'doctorUuid': ['',Validators.required],
      'prescriptions': this.fb.array([],minLengthArray(1)),
    })
  }
}
