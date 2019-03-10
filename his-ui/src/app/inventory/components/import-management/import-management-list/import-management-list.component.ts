import {Component, OnInit} from '@angular/core';
import {InventoryImportSheetService} from "../../../../core/services/inventory/inventory-import-sheet.service";

@Component({
  selector: 'app-import-management-list',
  templateUrl: './import-management-list.component.html',
  styleUrls: ['./import-management-list.component.css']
})
export class ImportManagementListComponent implements OnInit {


  importReceipts: any[] = [];

  constructor(private inventoryImportSheetService:InventoryImportSheetService) {
  }

  ngOnInit() {
    this.loadData();
  }

  loadData() {
    this.inventoryImportSheetService.readAll().subscribe(r => {
      this.importReceipts = r;
    })
  }

  selectedImportReceipt: any = {};

  onRowClicked(importReceipt: any) {
    this.selectedImportReceipt = importReceipt;

  }

  isRowSelected(importReceipt: any): boolean {
    return this.selectedImportReceipt == importReceipt;
  }

  getImportReceiptItemCount(importReceipt: any):string {

    return "a";
  }


  getImportReceiptTotalSum(importReceipt: any):string {

    return "b";
  }
}
