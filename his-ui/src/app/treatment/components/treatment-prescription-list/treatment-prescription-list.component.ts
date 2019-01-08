import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {ReportStatusEnum} from "../../../core/enums/report-status.enum";

@Component({
  selector: 'app-treatment-prescription-list',
  templateUrl: './treatment-prescription-list.component.html',
  styleUrls: ['./treatment-prescription-list.component.css']
})
export class TreatmentPrescriptionListComponent implements OnInit {

  @Input()
  list: any[];
  @Output()
  listChanged = new EventEmitter();
  @Output()
  itemSelected = new EventEmitter<any>();

  @Input()
  selectedPrescription: any;

  onRowClicked(item: any) {
    this.itemSelected.emit(item);
  }

  isRowSelected(item: any) {
    return item === this.selectedPrescription;
  }

  constructor() {
  }

  ngOnInit() {
  }

  getStatusText(status: any): string {
    return ReportStatusEnum[status];
  }

}
