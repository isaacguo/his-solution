import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {PageableParams} from "../../../core/models/pageable-params.model";

@Component({
  selector: 'app-pharmacy-dispensing',
  templateUrl: './pharmacy-dispensing.component.html',
  styleUrls: ['./pharmacy-dispensing.component.css']
})
export class PharmacyDispensingComponent implements OnInit {

  @Input()
  pageData: any;

  @Output()
  pageChanged = new EventEmitter<number>();
  @Output()
  statusChanged = new EventEmitter<PageableParams>();
  @Output()
  itemSelected = new EventEmitter<any>();

  @Input()
  selectedPrescription: any;

  constructor() {
    this.pageData = [];
  }


  ngOnInit() {
  }

  onPageChanged(event) {
    this.pageChanged.emit(event - 1);
  }

  isRowSelected(item: any) {
    return item === this.selectedPrescription;
  }

  onRowClicked(prescription: any) {
    this.itemSelected.emit(prescription);
  }
}
