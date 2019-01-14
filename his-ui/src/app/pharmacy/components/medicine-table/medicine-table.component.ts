import {Component, EventEmitter, Input, OnInit, Output, ViewChild} from '@angular/core';
import {ModalComponent} from "ng2-bs3-modal/ng2-bs3-modal";
import {PrescriptionStatusEnum} from "../../../core/enums/prescription-status.enum";

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


  isPaid():boolean {
    return this.prescription.status === PrescriptionStatusEnum.PAID;
  }

  isWithdrew():boolean {
    return this.prescription.status === PrescriptionStatusEnum.WITHDREW;
  }
}
