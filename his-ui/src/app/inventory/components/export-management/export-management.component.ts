import {Component, OnInit} from '@angular/core';
import {AbstractItemSelectableTableComponent} from "../../../shared/components/abstract-item-selectable-table/abstract-item-selectable-table.component";

@Component({
  selector: 'app-export-management',
  templateUrl: './export-management.component.html',
  styleUrls: ['./export-management.component.css']
})
export class ExportManagementComponent extends AbstractItemSelectableTableComponent<any> {

  constructor() {
    super();
  }

  ngOnInit() {
  }

}
