import {CanActivate, Router} from "@angular/router";
import {Injectable, OnDestroy} from "@angular/core";
import {Observable} from "rxjs/Observable";
import {AuthenticationService, AuthInfo} from "../services/common/authentication.service";
import {AuthorizationService} from "../services/common/authorization.service";
import {AdminGuard} from "./admin.guard";
import {Subscription} from "rxjs/Subscription";

@Injectable()
export class EmployeeManagementGuard implements CanActivate, OnDestroy {


  ngOnDestroy(): void {
    this.authChangeSubscription.unsubscribe();
  }

  private static TOPIC: string = "员工管理";
  private static OPERATION: string = "管理";


  authInfo: AuthInfo;

  private authChangeSubscription: Subscription;

  constructor(private authorizationService: AuthorizationService, private authenticationService: AuthenticationService) {

    this.authChangeSubscription = authenticationService.authChange.subscribe(
      newAuthInfo => {
        this.authInfo = newAuthInfo;
      }
    );

  }

  canActivate(): boolean {
    if (this.authInfo.isAdmin)
      return true;
    else {
      return this.authorizationService
        .isAuthorized("Employee",
          EmployeeManagementGuard.TOPIC,
          EmployeeManagementGuard.OPERATION);
    }
  }
}
