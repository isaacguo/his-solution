import {CanActivate, Router} from "@angular/router";
import {Injectable} from "@angular/core";
import {Observable} from "rxjs/Observable";
import {AuthenticationService} from "../services/common/authentication.service";
import {AuthorizationService} from "../services/common/authorization.service";

@Injectable()
export class ProcurementApprovalGuard implements CanActivate {

  private static TOPIC: string = "采购审批";
  private static OPERATION: string = "管理";

  constructor(private authorizationService: AuthorizationService) {

  }

  canActivate(): boolean {
    return this.authorizationService
      .isAuthorized("Procurement",
        ProcurementApprovalGuard.TOPIC,
        ProcurementApprovalGuard.OPERATION);
  }
}
