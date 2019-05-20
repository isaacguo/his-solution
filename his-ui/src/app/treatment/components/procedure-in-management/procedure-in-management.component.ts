import {Component, OnInit, ViewChild} from '@angular/core';
import {ModalComponent} from "ng2-bs3-modal/ng2-bs3-modal";
import {InpatientManagementService} from "../../../core/services/treatment/inpatient-management.service";
import {Observable} from "rxjs";
import {InpatientManagement} from "../../../core/models/treatment/model.component";

@Component({
  selector: 'app-procedure-in-management',
  templateUrl: './procedure-in-management.component.html',
  styleUrls: ['./procedure-in-management.component.css']
})
export class ProcedureInManagementComponent implements OnInit {

  records: Observable<InpatientManagement[]>;
  @ViewChild("createInpatientModal") createInpatientModal: ModalComponent;


  constructor(private inpatientManagementService: InpatientManagementService) {
  }

  ngOnInit() {
    this.records = this.inpatientManagementService.getRecordsByStatus("Inpatient");
  }


  onCreateNewInpatientRecordClicked() {
    this.createInpatientModal.open();
  }
}
