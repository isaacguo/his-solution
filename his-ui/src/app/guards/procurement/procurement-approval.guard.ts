import {CanActivate} from "@angular/router";
import {Injectable} from "@angular/core";
import {AbstractGuard} from "../abstract.guard";
import {AuthorizationService} from "../../services/common/authorization.service";

@Injectable()
export class ProcurementApprovalGuard extends AbstractGuard implements CanActivate {

  constructor(authorizationService: AuthorizationService) {
    super("Procurement","采购审批","操作",authorizationService);
  }

  canActivate(): boolean {
    return this.isAuthorized();
  }
}
