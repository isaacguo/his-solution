import {Component, OnDestroy, OnInit} from '@angular/core';
import {AuthenticationService, AuthInfo} from "../../services/common/authentication.service";
import {Subscription} from "rxjs/Subscription";
import {ProcurementApprovalService} from "../../services/procurement/procurement-approval.service";
import {EmployeeService} from "../../services/employee/employee.service";
import {ProcurementApprovalGuard} from "../../guards/procurement/procurement-approval.guard";
import {EmployeeManagementGuard} from "../../guards/employee/employee-management.guard";
import {MyConsultingRoomGuard} from "../../guards/treatment/my-consulting-room.guard";
import {FrontdeskGuard} from "../../guards/treatment/frontdesk.guard";
import {TreatmentSettingsGuard} from "../../guards/treatment/treatment-settings.guard";
import {FinanceManagementGuard} from "../../guards/finance/finance-management.guard";
import {InpatientManagementGuard} from "../../guards/treatment/inpatient-management.guard";
import {MedicineManagementGuard} from "../../guards/medicine/medicine-management.guard";
import {MedicalTestManagementGuard} from "../../guards/medical-test/medical-test-management.guard";
import {ProcurementManagementGuard} from "../../guards/procurement/procurement-management.guard";

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css']
})
export class IndexComponent implements OnInit, OnDestroy {

  authInfo: AuthInfo;
  userName: string;

  private authChangeSubscription: Subscription;
  private unfinishedTaskCountSubscriptiion: Subscription;
  count: number = 0;

  ngOnDestroy(): void {
    this.authChangeSubscription.unsubscribe();
    this.unfinishedTaskCountSubscriptiion.unsubscribe();
  }

  getCount(): string {
    if (this.count == 0)
      return "";
    else
      return this.count + "";
  }

  constructor(private authenticationService: AuthenticationService,
              private procurementApprovalService: ProcurementApprovalService,
              public procurementApprovalGuard: ProcurementApprovalGuard,
              public myConsultingRoomGuard: MyConsultingRoomGuard,
              public frontdeskGuard: FrontdeskGuard,
              public treatmentSettingsGuard: TreatmentSettingsGuard,
              private employeeService: EmployeeService,
              private employeeManagementGuard: EmployeeManagementGuard,
              private financeManagementGuard: FinanceManagementGuard,
              private inpatientManagementGuard: InpatientManagementGuard,
              private medicineManagementGuard: MedicineManagementGuard,
              private medicalTestManagementGuard: MedicalTestManagementGuard,
              private procurementManagementGuard:ProcurementManagementGuard) {

    this.authChangeSubscription = authenticationService.authChange.subscribe(
      newAuthInfo => {
        this.authInfo = newAuthInfo;
        this.userName = this.authInfo.displayName;
        this.employeeService.getMyInfo().subscribe(r => {
          this.userName = r.fullName;
        })
      }
    );

    this.unfinishedTaskCountSubscriptiion = procurementApprovalService.unfinishedTasksChange.subscribe(
      r => this.count = r)
    this.procurementApprovalService.updateUnfinishedApprovalCount();
  }

  canShowApproval(): boolean {
    return this.procurementApprovalGuard.canActivate();
  }

  canShowEmployeeManagement(): boolean {
    return this.employeeManagementGuard.canActivate();
  }

  canShowFrontdesk(): boolean {
    return this.frontdeskGuard.canActivate();
  }

  canShowMedicineManagement(): boolean {
    return this.medicineManagementGuard.canActivate();
  }

  canShowInpatientManagement(): boolean {
    return this.inpatientManagementGuard.canActivate();
  }

  canShowMedicalTestManagement(): boolean {
    return this.medicalTestManagementGuard.canActivate();
  }

  canShowFinanceManagement(): boolean {
    return this.financeManagementGuard.canActivate();
  }

  canShowMyConsultingRoom(): boolean {
    return this.myConsultingRoomGuard.canActivate();
  }
  canShowProcurementManagement():boolean{
    return this.procurementManagementGuard.canActivate();
  }

  ngOnInit() {
    this.canShowApproval();
    this.canShowEmployeeManagement()
  }

  onLoginBtnClicked() {
  }

  canShowTreatmentSettings() {
    return this.treatmentSettingsGuard.canActivate();
  }
}
