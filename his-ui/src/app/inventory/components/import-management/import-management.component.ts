import {Component, Input, OnInit} from '@angular/core';
import {AbstractItemSelectableTableComponent} from "../../../shared/components/abstract-item-selectable-table/abstract-item-selectable-table.component";

@Component({
  selector: 'app-import-management',
  templateUrl: './import-management.component.html',
  styleUrls: ['./import-management.component.css']
})
export class ImportManagementComponent extends AbstractItemSelectableTableComponent<any>  {

  @Input()
  importReceipts:any[];

  constructor() {
    super();
  }

  getImportReceiptItemCount(importReceipt: any) {

  }

  getImportReceiptTotalSum(importReceipt: any) {

  }
}
