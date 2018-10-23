import {Component, EventEmitter, Input, OnInit, Output, ViewChild} from '@angular/core';
import {Medicine} from "../../models/medicine.model";
import {ModalComponent} from "ng2-bs3-modal/ng2-bs3-modal";
import {MedicineInfo} from "../../models/medicine-info.model";

@Component({
  selector: 'app-medicine-table',
  templateUrl: './medicine-table.component.html',
  styleUrls: ['./medicine-table.component.css']
})
export class MedicineTableComponent implements OnInit {

  @Input()
  medicineInfo: MedicineInfo;
  @Output()
  medicineDispensed = new EventEmitter();
  @ViewChild("confirmModal")
  confirmModal: ModalComponent;

  constructor() {
  }

  ngOnInit() {
  }

  onMedicineDispensedButtonClicked() {
    this.confirmModal.open();
  }

  onConfirmModalClosed() {
    this.medicineDispensed.emit();
  }
}
