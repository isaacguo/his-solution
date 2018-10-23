import { Component, OnInit } from '@angular/core';
import {AbstractItemSelectableTableComponent} from "../../../shared/components/abstract-item-selectable-table/abstract-item-selectable-table.component";

@Component({
  selector: 'app-pharmacy-dispensing',
  templateUrl: './pharmacy-dispensing.component.html',
  styleUrls: ['./pharmacy-dispensing.component.css']
})
export class PharmacyDispensingComponent extends AbstractItemSelectableTableComponent<any> implements OnInit {

  constructor() {
    super();
  }

  ngOnInit() {
  }

}
