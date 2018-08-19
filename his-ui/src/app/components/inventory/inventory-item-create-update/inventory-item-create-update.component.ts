import {Component, OnInit, ViewChild} from '@angular/core';
import {AbstractCreateUpdateComponent} from "../../common/abstract-create-update.component";
import {ActivatedRoute, Router} from "@angular/router";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {InventoryItemService} from "../../../services/inventory/inventory-item.service";
import {ModalComponent} from "ng2-bs3-modal/ng2-bs3-modal";
import {OperationEnum} from "../../../enums/operation.enum";

@Component({
  selector: 'app-inventory-item-create-update',
  templateUrl: './inventory-item-create-update.component.html',
  styleUrls: ['./inventory-item-create-update.component.css']
})
export class InventoryItemCreateUpdateComponent extends AbstractCreateUpdateComponent implements OnInit {

  formModel: FormGroup;
  itemCreationResultText: string;
  @ViewChild("confirmCreateModal") confirmCreateModal: ModalComponent;

  constructor(public router: Router, public route: ActivatedRoute, private fb: FormBuilder, private inventoryItemService: InventoryItemService) {
    super(route);

  }

  private initForm() {
    this.formModel = this.fb.group({
      'categoryId':[''],
      'id': [''],
      'inventoryId': ['', [Validators.required]],
      'name': [''],
      'unit': [''],
      'specification': [''],
    })
  }

  categoryId: number;

  ngOnInit() {

    this.initForm();

    this.process();

    if (this.operation === OperationEnum.CREATE) {
      this.route.params.subscribe(params => {
        this.categoryId = params['updateId'];
      });
    }

    /*
    if (this.operation === OperationEnum.UPDATE) {

      this.vendorService.findById(this.updateId).subscribe(r => {
        this.inflatFormModelWithValues(r);
        this.clearContacts();
        r.contacts.forEach(contact => {
          this.inflateContact(contact);
        })
      })
    }
    */
  }

  invokeWhenCreate() {

    this.formModel.controls['categoryId'].setValue(this.categoryId);

    this.inventoryItemService.create(this.formModel.value).subscribe(r=>{
      this.itemCreationResultText="产品信息添加成功";
      this.confirmCreateModal.open();


    });
  }

  invokeWhenUpdate() {
  }


  onConfirmCreateModalClosed()
  {

  }


}
