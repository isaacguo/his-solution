import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {AbstractItemSelectableTableComponent} from "../../../shared/components/abstract-item-selectable-table/abstract-item-selectable-table.component";
import {TreatmentCase} from "../../models/treatment-case.model";

@Component({
  selector: 'app-selectable-treatment-case-table',
  templateUrl: './selectable-treatment-case-table.component.html',
  styleUrls: ['./selectable-treatment-case-table.component.css']
})
export class SelectableTreatmentCaseTableComponent implements OnInit {

  @Input()
  list: TreatmentCase[];
  @Output()
  listChanged=new EventEmitter();
  @Output()
  itemSelected = new EventEmitter<TreatmentCase>();

  @Input()
  selectedTreatmentCase: TreatmentCase;

  onRowClicked(item: TreatmentCase) {
    this.itemSelected.emit(item);
  }

  isRowSelected(item: TreatmentCase) {
    return item === this.selectedTreatmentCase;
  }


  constructor() {
  }

  ngOnInit() {
  }

}