import {Component, EventEmitter, Input, OnInit, Output, ViewChild} from '@angular/core';
import {ModalComponent} from "ng2-bs3-modal/ng2-bs3-modal";

@Component({
  selector: 'app-medicine-table',
  templateUrl: './medicine-table.component.html',
  styleUrls: ['./medicine-table.component.css']
})
export class MedicineTableComponent implements OnInit {

  @Input()
  prescription: any;
  @Output()
  medicineDispensed = new EventEmitter();

  @Output()
  withdrawMedicine = new EventEmitter();
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

  onWithdrewButtonClicked() {
    this.withdrawMedicine.emit();
  }
}
