import {Component, Input, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {OperationEnum} from "../../../core/enums/operation.enum";

@Component({
  selector: 'app-inventory-operation-tool-bar',
  templateUrl: './inventory-operation-tool-bar.component.html',
  styleUrls: ['./inventory-operation-tool-bar.component.css']
})
export class InventoryOperationToolBarComponent implements OnInit {


  @Input()
  importMode: boolean = true;

  constructor(private router: Router,
              private route: ActivatedRoute) {
  }

  ngOnInit() {
  }

  onCreateNewImportSheet() {
    this.router.navigate(['inventory-import', OperationEnum.CREATE], {relativeTo: this.route.parent});
  }

  onCreateNewExportSheet() {
    this.router.navigate(['inventory-export', OperationEnum.CREATE], {relativeTo: this.route.parent});
  }
}
