import {Component, Input, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {OperationEnum} from "../../../enums/operation.enum";

@Component({
  selector: 'app-inventory-operation-tool-bar',
  templateUrl: './inventory-operation-tool-bar.component.html',
  styleUrls: ['./inventory-operation-tool-bar.component.css']
})
export class InventoryOperationToolBarComponent implements OnInit {


  @Input()
  importMode: boolean = true;

  constructor(private router: Router) { }

  ngOnInit() {
  }

  onCreateNewImportSheet() {
      this.router.navigate(['inventory-import', OperationEnum.CREATE]);
  }

  onCreateNewExportSheet() {
    this.router.navigate(['inventory-export', OperationEnum.CREATE]);
  }
}
