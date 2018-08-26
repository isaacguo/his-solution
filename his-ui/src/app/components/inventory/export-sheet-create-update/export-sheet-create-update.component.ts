import {Component, OnInit, ViewChild} from '@angular/core';
import {InventoryImportSheetService} from "../../../services/inventory/inventory-import-sheet.service";
import {ModalComponent} from "ng2-bs3-modal/ng2-bs3-modal";
import {FormArray, FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {InventoryItemService} from "../../../services/inventory/inventory-item.service";
import {AbstractCreateUpdateComponent} from "../../common/abstract-create-update.component";
import {Observable} from "rxjs/Observable";
import {InventoryExportSheetService} from "../../../services/inventory/inventory-export-sheet.service";

@Component({
  selector: 'app-export-sheet-create-update',
  templateUrl: './export-sheet-create-update.component.html',
  styleUrls: ['./export-sheet-create-update.component.css']
})
export class ExportSheetCreateUpdateComponent  extends AbstractCreateUpdateComponent implements OnInit {

  @ViewChild("confirmCreateModal") confirmCreateModal: ModalComponent;
  formModel: FormGroup;

  constructor(public router: Router,
              public route: ActivatedRoute,
              private fb: FormBuilder,
              private inventoryExportSheetService: InventoryExportSheetService,
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
      'customer': [''],
      'customerContact': [''],
      'operator': [''],
      'auditor': [''],
      'exportItemList':this.fb.array([]),
      // 'importItemList': this.fb.array([
      //   this.initImportItem()
      // ]),
      'comments':['']
    })
  }


  private initExportItem(item:any) {
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

    this.inventoryExportSheetService.create(this.formModel.value).subscribe(r => {
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

  get exportItemListData() {
    return <FormArray>this.formModel.get('exportItemList');
  }

  removeItem(i: number) {
    // remove address from the list
    const control = <FormArray>this.formModel.controls['exportItemList'];
    control.removeAt(i);
  }


  addItem(item:any) {
    // add address to the list
    const control = <FormArray>this.formModel.controls['exportItemList'];

    control.push(this.initExportItem(item));

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
