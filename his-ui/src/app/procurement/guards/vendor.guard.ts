import {CanActivate} from "@angular/router";
import {Injectable} from "@angular/core";
import {AbstractGuard} from "../../shared/guards/abstract.guard";
import {AuthorizationService} from "../../core/services/common/authorization.service";

@Injectable()
export class VendorGuard extends AbstractGuard implements CanActivate {

  constructor(authorizationService: AuthorizationService) {
    super("Procurement", "供应商管理", "操作", authorizationService);
  }

  canActivate(): boolean {
    return this.isAuthorized();
  }
}
