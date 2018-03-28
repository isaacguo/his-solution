import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {AbstractCreateUpdateComponent} from "../../../common/abstract-create-update.component";
import {FormArray, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {OperationEnum} from "../../../../enums/operation.enum";

@Component({
  selector: 'app-vendor-create-update',
  templateUrl: './vendor-create-update.component.html',
  styleUrls: ['./vendor-create-update.component.css']
})
export class VendorCreateUpdateComponent extends AbstractCreateUpdateComponent implements OnInit {

  formModel:FormGroup;

  getOperationText(){
    return this.operation===OperationEnum.CREATE?"创建":"修改";
  }

  constructor(public router: Router, public route: ActivatedRoute, private fb:FormBuilder) {
    super(route);


    this.formModel=this.fb.group({
      'name': ['',[Validators.required]],
      'contacts': this.fb.array([
        this.initContacts()
      ]),
      'address':[''],
      'postcode':[''],
      'legalPerson':[''],
      'officialWebsiteLink':[''],
      'email':[''],

    })
  }

  initContacts()
  {
    return this.fb.group({
      'name':['',Validators.required],
      'telephone':['',Validators.required],
    })
  }

  ngOnInit() {
    this.process();
  }

  addContact() {
    // add address to the list
    const control = <FormArray>this.formModel.controls['contacts'];
    control.push(this.initContacts());
  }

  removeContact(i: number) {
    // remove address from the list
    const control = <FormArray>this.formModel.controls['contacts'];
    control.removeAt(i);
  }



  onSubmit()
  {

  }

}
