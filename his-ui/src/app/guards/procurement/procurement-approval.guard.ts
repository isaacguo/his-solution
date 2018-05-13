import {CanActivate} from "@angular/router";
import {Injectable} from "@angular/core";
import {AbstractGuard} from "../abstract.guard";
import {AuthorizationService} from "../../services/common/authorization.service";

@Injectable()
export class ProcurementApprovalGuard extends AbstractGuard implements CanActivate {

  constructor(authorizationService: AuthorizationService) {
    super("Procurement","ProcurementApproval","Admin",authorizationService);
  }

  canActivate(): boolean {
    return this.isAuthorized();
  }
}
