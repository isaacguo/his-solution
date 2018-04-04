import {Component, OnInit} from '@angular/core';
import {AbstractCreateUpdateComponent} from "../../../common/abstract-create-update.component";
import {ActivatedRoute, Router} from "@angular/router";
import {ProcurementRequestService} from "../../../../services/procurement/procurement-request.service";
import {FormArray, FormBuilder, FormGroup} from "@angular/forms";
import {ProcurementService} from "../../../../services/procurement/procurement.service";

@Component({
  selector: 'app-procurement-purchase-create-update',
  templateUrl: './procurement-purchase-create-update.component.html',
  styleUrls: ['./procurement-purchase-create-update.component.css']
})
export class ProcurementPurchaseCreateUpdateComponent extends AbstractCreateUpdateComponent implements OnInit {

  availableProcurementStatus: string[] = [];
  selectedStatus: string;

  formModel: FormGroup;

  constructor(public router: Router, public route: ActivatedRoute, private fb: FormBuilder) {
    super(route);
  }

  ngOnInit() {
    this.initForm();
    this.process();

    this.formModel.controls['procurementId'].setValue(this.updateId);
    /*
    this.availableProcurementStatus.push("采购进行中");
    if (this.operation === OperationEnum.UPDATE)
      this.availableProcurementStatus.push("采购已到货");
    */
  }

  get goodsData() {
    return <FormArray>this.formModel.get('goods');
  }

  private initForm() {
    this.formModel = this.fb.group({
      'id': [''],
      'procurementId': [''],
      'goods': this.fb.array([
        this.initGood()
      ])
    })
  }

  private initGood() {
    return this.fb.group({
      'vendor': [''],
      'contact':[''],
      'contactTelephone':[''],
      'number':[''],
      'packageSpecification':[''],
      'packageUnit':[''],
      'otherRequirements':[''],
      'pricePerUnit':[''],
      'totalPrice':[''],
    })
  }

  invokeWhenCreate() {
  }

  invokeWhenUpdate() {
  }

  onSubmit()
  {

  }

  addGood() {
    // add good to the list
    const control = <FormArray>this.formModel.controls['goods'];
    control.push(this.initGood());
  }

  removeGood(i: number) {
    // remove good from the list
    const control = <FormArray>this.formModel.controls['goods'];
    control.removeAt(i);
  }


}
