import {CanActivate, Router} from "@angular/router";
import {Injectable} from "@angular/core";
import {Observable} from "rxjs/Observable";
import {AuthenticationService} from "../services/common/authentication.service";
import {AuthorizationService} from "../services/common/authorization.service";

@Injectable()
export class ProcurementApprovalGuard implements CanActivate {

  private static TOPIC: string = "审批";
  private static OPERATION: string = "查看";

  constructor(private authorizationService: AuthorizationService) {

  }

  canActivate(): Observable<boolean> {
    return this.authorizationService
      .isAuthorized(AuthorizationService.serviceMap.get("Procurement"),
        ProcurementApprovalGuard.TOPIC,
        ProcurementApprovalGuard.OPERATION).map(r => {

        return r;
      }).take(1);
  }

}
