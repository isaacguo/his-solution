import {Component, OnInit} from '@angular/core';
import {PetInfo} from "../../../../services/treatment/pet.service";
import {PetOperationRequest} from "../../../../dto/treatment/pet.operation.request";
import {ProductImportReceiptService} from "../../../../services/medicine/product-import-receipt.service";

@Component({
  selector: 'app-import-management-list',
  templateUrl: './import-management-list.component.html',
  styleUrls: ['./import-management-list.component.css']
})
export class ImportManagementListComponent implements OnInit {


  importReceipts: any[] = [];

  constructor(private productImportReceiptService: ProductImportReceiptService) {
  }

  ngOnInit() {
    this.loadData();
  }

  loadData() {
    this.productImportReceiptService.readAll().subscribe(r => {
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

  getImportReceiptItemCount(importReceipt: any) {

  }


  getImportReceiptTotalSum(importReceipt: any) {

  }
}
