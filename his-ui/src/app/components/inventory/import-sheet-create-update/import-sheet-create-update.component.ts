import {Component, OnInit, ViewChild} from '@angular/core';
import {FormArray, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {VendorService} from "../../../services/procurement/vendor.service";
import {InventoryImportSheetService} from "../../../services/inventory/inventory-import-sheet.service";
import {AbstractCreateUpdateComponent} from "../../common/abstract-create-update.component";
import {ModalComponent} from "ng2-bs3-modal/ng2-bs3-modal";

@Component({
  selector: 'app-import-sheet-create-update',
  templateUrl: './import-sheet-create-update.component.html',
  styleUrls: ['./import-sheet-create-update.component.css']
})
export class ImportSheetCreateUpdateComponent extends AbstractCreateUpdateComponent implements OnInit {

  @ViewChild("confirmCreateModal") confirmCreateModal: ModalComponent;
  formModel: FormGroup;

  constructor(public router: Router, public route: ActivatedRoute, private fb: FormBuilder, private inventoryImportSheetService: InventoryImportSheetService) {
    super(route);
  }

  private initForm() {
    this.formModel = this.fb.group({
      'id': [''],
      'sheetNumber': [''],
      'uuid': [''],
      'vendor': [''],
      'vendorContact': [''],
      'operator': [''],
      'auditor': [''],
      'importItemList': this.fb.array([
        this.initImportItem()
      ]),
      'comments':['']
    })
  }


  private initImportItem() {
    return this.fb.group({
      'name': ['', Validators.required],
      'unit': ['', Validators.required],
      'specification': [''],
      'amount':[''],
      'pricePerUnit': [''],
      'totalPrice': [''],
      'comments': ['']
    })
  }

  ngOnInit() {
    this.initForm();
  }

  resultText: string;

  invokeWhenCreate() {

    this.inventoryImportSheetService.create(this.formModel.value).subscribe(r => {
      if (r.id > 0) {
        this.resultText = "信息添加成功";
        this.confirmCreateModal.open();
      }
    });
  }

  invokeWhenUpdate() {
  }

  onConfirmCreateModalClosed()
  {}

  get importItemListData() {
    return <FormArray>this.formModel.get('importItemList');
  }

  removeItem(i: number) {
    // remove address from the list
    const control = <FormArray>this.formModel.controls['importItemList'];
    control.removeAt(i);
  }


  addItem() {
    // add address to the list
    const control = <FormArray>this.formModel.controls['importItemList'];
    control.push(this.initImportItem());
  }
}
