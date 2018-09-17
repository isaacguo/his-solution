import {Component, OnInit} from '@angular/core';
import {InventoryExportSheetService} from "../../../../core/services/inventory/inventory-export-sheet.service";

@Component({
  selector: 'app-export-management-list',
  templateUrl: './export-management-list.component.html',
  styleUrls: ['./export-management-list.component.css']
})
export class ExportManagementListComponent implements OnInit {


  exportReceipts: any[] = [];

  constructor(private inventoryExportSheetService:InventoryExportSheetService) {
  }

  ngOnInit() {
    this.loadData();
  }

  loadData() {
    this.inventoryExportSheetService.readAll().subscribe(r => {
      this.exportReceipts = r;
    })
  }

  selectedExportReceipt: any = {};

  onRowClicked(exportReceipt: any) {
    this.selectedExportReceipt = exportReceipt;

  }

  isRowSelected(exportReceipt: any): boolean {
    return this.selectedExportReceipt == exportReceipt;
  }

  getExportReceiptItemCount(exportReceipt: any):string {

    return "a";
  }


  getExportReceiptTotalSum(exportReceipt: any):string {

    return "b";
  }

}
