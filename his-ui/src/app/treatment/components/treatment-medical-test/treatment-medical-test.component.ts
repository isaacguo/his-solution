import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-treatment-medical-test',
  templateUrl: './treatment-medical-test.component.html',
  styleUrls: ['./treatment-medical-test.component.css']
})
export class TreatmentMedicalTestComponent implements OnInit {

  @Input()
  list: any[];
  @Output()
  listChanged=new EventEmitter();
  @Output()
  itemSelected = new EventEmitter<any>();

  @Input()
  selectedMedicalTest: any;

  onRowClicked(item: any) {
    this.itemSelected.emit(item);
  }

  isRowSelected(item: any) {
    return item === this.selectedMedicalTest;
  }
  constructor() {
  }

  ngOnInit() {
  }

}
