import {Component, OnInit, ViewChild} from '@angular/core';
import {FormArray, FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {VendorService} from "../../../services/procurement/vendor.service";
import {InventoryImportSheetService} from "../../../services/inventory/inventory-import-sheet.service";
import {AbstractCreateUpdateComponent} from "../../common/abstract-create-update.component";
import {ModalComponent} from "ng2-bs3-modal/ng2-bs3-modal";
import {Observable} from "rxjs/Observable";
import {InventoryItemService} from "../../../services/inventory/inventory-item.service";

@Component({
  selector: 'app-import-sheet-create-update',
  templateUrl: './import-sheet-create-update.component.html',
  styleUrls: ['./import-sheet-create-update.component.css']
})
export class ImportSheetCreateUpdateComponent extends AbstractCreateUpdateComponent implements OnInit {

  @ViewChild("confirmCreateModal") confirmCreateModal: ModalComponent;
  formModel: FormGroup;

  constructor(public router: Router,
              public route: ActivatedRoute,
              private fb: FormBuilder,
              private inventoryImportSheetService: InventoryImportSheetService,
              private inventoryItemService:InventoryItemService) {
    super(route);

    this.searchInput.valueChanges
      .debounceTime(200)
      .switchMap(name => {

        if (name === "") {
          return Observable.of([]);
        }
        else {
          return this.inventoryItemService.findByNameContains(name);
        }
      })
      .subscribe(r => {
        this.searchedItems = r;
      })
  }

  searchInput: FormControl = new FormControl('', [Validators.required, Validators.minLength(1)]);

  searchedItems: any[] = [];

  private initForm() {
    this.formModel = this.fb.group({
      'id': [''],
      'sheetNumber': [''],
      'uuid': [''],
      'vendor': [''],
      'vendorContact': [''],
      'operator': [''],
      'auditor': [''],
      'importItemList':this.fb.array([]),
      // 'importItemList': this.fb.array([
      //   this.initImportItem()
      // ]),
      'comments':['']
    })
  }


  private initImportItem(item:any) {
    return this.fb.group({
      'name': [item.name, Validators.required],
      'unit': [item.unit, Validators.required],
      'specification': [item.specification,Validators.required],
      'amount':['',[Validators.required,Validators.pattern(/^-?\d*(\.\d+)?$/)]],
      'batchNumber':['',Validators.required],
      'pricePerUnit': ['',[Validators.required,Validators.pattern(/^-?\d*(\.\d+)?$/)]],
      'totalPrice': ['',[Validators.required,Validators.pattern(/^-?\d*(\.\d+)?$/)]],
      'comments': [''],
      'inventoryItemId':[item.id]
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


  addItem(item:any) {
    // add address to the list
    const control = <FormArray>this.formModel.controls['importItemList'];

    control.push(this.initImportItem(item));

  }

  stopPropagation($event) {
    event.stopPropagation()
  }

  onSearchedItemSelected(item:any)
  {
    this.addItem(item);
    this.searchInput.setValue("");

  }
}
