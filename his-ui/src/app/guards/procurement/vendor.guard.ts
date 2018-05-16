import {CanActivate, Router} from "@angular/router";
import {Injectable} from "@angular/core";
import {Observable} from "rxjs/Observable";
import {AuthorizationService} from "../../services/common/authorization.service";
import {AbstractGuard} from "../abstract.guard";

@Injectable()
export class VendorGuard extends AbstractGuard implements CanActivate {

  constructor(authorizationService: AuthorizationService) {
    super("Procurement", "供应商管理", "操作", authorizationService);
  }

  canActivate(): boolean {
    return this.isAuthorized();
  }
}
