///<reference path="../../../../node_modules/protractor/built/index.d.ts"/>
import {AfterViewInit, Component, ElementRef, OnDestroy, OnInit} from '@angular/core';
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
import {ChargeManagementGuard} from "../../guards/finance/charge-management.guard";
import {InventoryManagementGuard} from "../../guards/medicine/inventory-management.guard";
import {Observable} from "rxjs/Observable";
declare let $: any;

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css']
})
export class IndexComponent implements OnInit, OnDestroy,AfterViewInit {

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

  constructor(private elementRef: ElementRef,
              private authenticationService: AuthenticationService,
              private procurementApprovalService: ProcurementApprovalService,
              public procurementApprovalGuard: ProcurementApprovalGuard,
              public myConsultingRoomGuard: MyConsultingRoomGuard,
              public frontdeskGuard: FrontdeskGuard,
              public treatmentSettingsGuard: TreatmentSettingsGuard,
              private employeeService: EmployeeService,
              private employeeManagementGuard: EmployeeManagementGuard,
              private financeManagementGuard: FinanceManagementGuard,
              private chargeManagementGuard: ChargeManagementGuard,
              private inpatientManagementGuard: InpatientManagementGuard,
              private medicineManagementGuard: MedicineManagementGuard,
              private inventoryManagementGuard: InventoryManagementGuard,
              private medicalTestManagementGuard: MedicalTestManagementGuard,
              private procurementManagementGuard: ProcurementManagementGuard) {

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

  canShowInventoryManagement(): boolean {
    return this.inventoryManagementGuard.canActivate();
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

  canShowProcurementManagement(): boolean {
    return this.procurementManagementGuard.canActivate();
  }

  ngOnInit() {
    this.canShowApproval();
    this.canShowEmployeeManagement()
  }

  canShowTreatmentSettings() {
    return this.treatmentSettingsGuard.canActivate();
  }

  canShowChargeManagement() {
    return this.chargeManagementGuard.canActivate();

  }

  ngAfterViewInit(): void {
    Observable.timer(2000).subscribe(r=>{
      let menuElement = this.elementRef.nativeElement.querySelector('#side-menu');
      $('#side-menu').metisMenu();
    })
  }

}
