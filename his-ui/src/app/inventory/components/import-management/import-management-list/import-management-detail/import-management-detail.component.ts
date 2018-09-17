import {Component, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {InventoryImportSheetService} from "../../../../services/inventory-import-sheet.service";

@Component({
  selector: 'app-import-management-detail',
  templateUrl: './import-management-detail.component.html',
  styleUrls: ['./import-management-detail.component.css']
})
export class ImportManagementDetailComponent implements OnInit, OnChanges {

  @Input()
  importReceiptId: number;

  importSheet: any;

  constructor(private  inventoryImportSheetService: InventoryImportSheetService) {
  }

  ngOnInit() {
  }

  loadData() {
    if (this.importReceiptId !== undefined && this.importReceiptId !== null) {

      this.inventoryImportSheetService.readOne(this.importReceiptId).subscribe(r => {
        this.importSheet = r;
      })
    }

  }

  ngOnChanges(changes: SimpleChanges): void {

    this.loadData();
  }

}
