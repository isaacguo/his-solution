import {Component, OnInit} from '@angular/core';
import {AbstractItemSelectableTableComponent} from "../../../shared/components/abstract-item-selectable-table/abstract-item-selectable-table.component";
import {TreatmentCase} from "../../models/treatment-case.model";

@Component({
  selector: 'app-selectable-treatment-case-table',
  templateUrl: './selectable-treatment-case-table.component.html',
  styleUrls: ['./selectable-treatment-case-table.component.css']
})
export class SelectableTreatmentCaseTableComponent extends AbstractItemSelectableTableComponent<TreatmentCase> implements OnInit {

  constructor() {
    super()
  }

  ngOnInit() {
  }

}
