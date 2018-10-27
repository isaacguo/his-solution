import {Component, OnInit} from '@angular/core';
import {FrontdeskGuard} from "../../guards/treatement/frontdesk.guard";
import {TreatmentSettingsGuard} from "../../guards/treatement/treatment-settings.guard";
import {MyConsultingRoomGuard} from "../../guards/treatement/my-consulting-room.guard";
import {EmployeeManagementGuard} from "../../guards/employee/employee-management.guard";
import {InpatientManagementGuard} from "../../guards/treatement/inpatient-management.guard";
import {EmployeeService} from "../../services/employee/employee.service";
import {MedicineManagementGuard} from "../../guards/medicine/medicine-management.guard";
import {MedicalTestManagementGuard} from "../../guards/medical-test/medical-test-management.guard";
import {InventoryManagementGuard} from "../../guards/inventory/inventory-management.guard";
import {ProcurementApprovalGuard} from "../../guards/procurement/procurement-approval.guard";
import {ProcurementManagementGuard} from "../../guards/procurement/procurement-management.guard";
import {FinanceManagementGuard} from "../../guards/finance/finance-management.guard";
import {ChargeManagementGuard} from "../../guards/finance/charge-management.guard";
import {PriceManagementGuard} from "../../guards/finance/price-management.guard";
import {AuthenticationService, AuthInfo} from "../../services/common/authentication.service";
import {Observable} from "rxjs/Observable";
import {BehaviorSubject} from "rxjs/BehaviorSubject";
import {GuardDelegation} from "../../guards/guard-delegation";
import {GuardFactoryService} from "../../services/guard-factory.service";

@Component({
  selector: 'app-index-container',
  templateUrl: './index-container.component.html',
  styleUrls: ['./index-container.component.css']
})
export class IndexContainerComponent implements OnInit {

  displayName$: Observable<string>;
  observableGuardMap$: Observable<Map<string, GuardDelegation>>;

  constructor(
    private authenticationService: AuthenticationService,
    private employeeService: EmployeeService,
    private guardFactoryService: GuardFactoryService
  ) {

    this.observableGuardMap$ = guardFactoryService.getObservableGuardsMap();
    this.displayName$ = authenticationService.authChange
      .mergeMap(() => this.employeeService.getMyInfo()).map(r => r.fullName);
  }

  ngOnInit() {
  }

}
