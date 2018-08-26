import {Component, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {InventoryExportSheetService} from "../../../../../services/inventory/inventory-export-sheet.service";

@Component({
  selector: 'app-export-management-detail',
  templateUrl: './export-management-detail.component.html',
  styleUrls: ['./export-management-detail.component.css']
})
export class ExportManagementDetailComponent implements OnInit, OnChanges {

  @Input()
  exportReceiptId: number;

  exportSheet: any;

  constructor(private  inventoryExportSheetService: InventoryExportSheetService) {
  }

  ngOnInit() {
  }

  loadData() {
    if (this.exportReceiptId !== undefined && this.exportReceiptId !== null) {

      this.inventoryExportSheetService.readOne(this.exportReceiptId).subscribe(r => {
        this.exportSheet = r;
      })
    }

  }

  ngOnChanges(changes: SimpleChanges): void {

    this.loadData();
  }
}

