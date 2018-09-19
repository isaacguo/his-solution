import {CanActivate} from "@angular/router";
import {Injectable} from "@angular/core";
import {AbstractGuard} from "../../../shared/guards/abstract.guard";
import {AuthorizationService} from "../../services/common/authorization.service";

@Injectable()
export class MedicineManagementGuard extends AbstractGuard implements CanActivate {

  constructor(authorizationService: AuthorizationService) {
    super("Medicine","药房管理","操作",authorizationService);
  }

  canActivate(): boolean {
    return this.isAuthorized();
  }
}
