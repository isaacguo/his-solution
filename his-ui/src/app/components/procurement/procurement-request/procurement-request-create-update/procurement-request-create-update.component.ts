import {Component, OnInit, ViewChild} from '@angular/core';
import {AbstractCreateUpdateComponent} from "../../../common/abstract-create-update.component";
import {ActivatedRoute, Router} from "@angular/router";
import {FormArray, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {OperationEnum} from "../../../../enums/operation.enum";
import {ProcurementRequestService} from "../../../../services/procurement/procurement-request.service";
import {ModalComponent} from "ng2-bs3-modal/ng2-bs3-modal";

@Component({
  selector: 'app-procurement-request-create-update',
  templateUrl: './procurement-request-create-update.component.html',
  styleUrls: ['./procurement-request-create-update.component.css']
})
export class ProcurementRequestCreateUpdateComponent extends AbstractCreateUpdateComponent implements OnInit {

  @ViewChild("confirmCreateModal")
  confirmCreateModal:ModalComponent;

  formModel: FormGroup;
  requestCreationResultText: string;
  getOperationText() {
    return this.operation === OperationEnum.CREATE ? "创建" : "修改";
  }

  constructor(public router: Router, public route: ActivatedRoute, private fb: FormBuilder, private procurementRequestService:ProcurementRequestService) {
    super(route);
  }

  private initForm() {
    this.formModel = this.fb.group({
      'id': [''],
      'goods': this.fb.array([
        this.initGood()
      ]),
    })
  }

  initGood() {
    return this.fb.group({
      'name': ['', Validators.required],
      'packageSpecification': ['', Validators.required],
      'packageUnit':['',Validators.required],
      'number': ['',[Validators.required,Validators.pattern(/^-?\d*(\.\d+)?$/)]],
      'otherRequirements':[''],
      'reason':['',Validators.required]
    })
  }

  get goodsData() {
    return <FormArray>this.formModel.get('goods');
  }

  addGood() {
    // add address to the list
    const control = <FormArray>this.formModel.controls['goods'];
    control.push(this.initGood());
  }

  removeGood(i: number) {
    // remove address from the list
    const control = <FormArray>this.formModel.controls['goods'];
    control.removeAt(i);
  }


  invokeWhenCreate() {
    this.procurementRequestService.createRequest(this.formModel.value).subscribe(r=>{
      if(r===true)
      {
        this.requestCreationResultText = "采购申请单提交成功";
        this.confirmCreateModal.open();
      }
      else {
        console.log("false");
      }
    });
  }

  onConfirmCreateModalClosed()
  {
    this.router.navigate(['procurement-request','list']);
  }

  invokeWhenUpdate() {
  }


  ngOnInit() {
    this.initForm();

    this.process();
  }

}
