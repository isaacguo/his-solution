import {Component, OnInit, ViewChild} from '@angular/core';
import {ModalComponent} from "ng2-bs3-modal/ng2-bs3-modal";

@Component({
  selector: 'app-procedure-in-management',
  templateUrl: './procedure-in-management.component.html',
  styleUrls: ['./procedure-in-management.component.css']
})
export class ProcedureInManagementComponent implements OnInit {
  @ViewChild("createInpatientModal") createInpatientModal: ModalComponent;

  constructor() { }

  ngOnInit() {
  }


  onCreateNewInpatientRecordClicked() {
    this.createInpatientModal.open();
  }
}
