import {Component, OnDestroy, OnInit} from '@angular/core';
import {AuthenticationService, AuthInfo} from "../../services/common/authentication.service";
import {Subscription} from "rxjs/Subscription";
import {ProcurementApprovalService} from "../../services/procurement/procurement-approval.service";
import {ProcurementApprovalGuard} from "../../guards/procurement-approval.guard";
import {EmployeeService} from "../../services/employee/employee.service";
import {EmployeeManagementGuard} from "../../guards/employee-management.guard";

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
              private employeeService: EmployeeService,
              private employeeManagementGuard: EmployeeManagementGuard) {
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

  ngOnInit() {
    this.canShowApproval();
    this.canShowEmployeeManagement()
  }

  onLoginBtnClicked() {
  }

}
