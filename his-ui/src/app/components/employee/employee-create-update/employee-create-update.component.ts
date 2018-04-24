import {Component, OnInit} from '@angular/core';
import {AbstractCreateUpdateComponent} from "../../common/abstract-create-update.component";
import {FormBuilder, FormGroup} from "@angular/forms";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-employee-create-update',
  templateUrl: './employee-create-update.component.html',
  styleUrls: ['./employee-create-update.component.css']
})
export class EmployeeCreateUpdateComponent extends AbstractCreateUpdateComponent implements OnInit {

  formModel: FormGroup;

  constructor(public route: ActivatedRoute,
              private fb: FormBuilder) {
    super(route);
  }

  invokeWhenCreate() {
  }

  invokeWhenUpdate() {
  }

  ngOnInit() {
    this.initForm();
    this.process();
  }

  private initForm() {
    this.formModel = this.fb.group({
      'id': [''],
      'procurementId': [''],
      'goods': this.fb.array([]),
      'totalPrice': ['']
    })
  }

}
