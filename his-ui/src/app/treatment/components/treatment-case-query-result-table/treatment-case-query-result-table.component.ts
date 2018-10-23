import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-treatment-case-query-result-table',
  templateUrl: './treatment-case-query-result-table.component.html',
  styleUrls: ['./treatment-case-query-result-table.component.css']
})
export class TreatmentCaseQueryResultTableComponent implements OnInit {


  @Input()
  list: any[];
  @Output()
  itemSelected = new EventEmitter<any>();

  selectedItem: any;

  constructor() {
  }

  ngOnInit() {
  }

  onRowClicked(treatmentCase: any) {
    this.itemSelected.emit(treatmentCase.id);
    this.selectedItem = treatmentCase;
  }

  isRowSelected(treatmentCase: any) {
    return treatmentCase === this.selectedItem
  }


}
