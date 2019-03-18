import { Component, OnInit } from '@angular/core';
import {FormGroup} from "@angular/forms";

@Component({
  selector: 'app-inpatient-record-create-update',
  templateUrl: './inpatient-record-create-update.component.html',
  styleUrls: ['./inpatient-record-create-update.component.css']
})
export class InpatientRecordCreateUpdateComponent implements OnInit {

  formModel: FormGroup;

  constructor() { }

  ngOnInit() {
  }

  onSubmit() {

  }
}
