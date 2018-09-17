import {CanActivate, Router} from "@angular/router";
import {Injectable, OnDestroy} from "@angular/core";
import {Observable} from "rxjs/Observable";
import {Subscription} from "rxjs/Subscription";
import {AbstractGuard} from "../../shared/guards/abstract.guard";
import {AuthorizationService} from "../../core/services/common/authorization.service";

@Injectable()
export class ProcurementManagementGuard extends AbstractGuard implements CanActivate {

  constructor(authorizationService: AuthorizationService) {
    super("Procurement","采购管理","操作",authorizationService);
  }

  canActivate(): boolean {
    return this.isAuthorized();
  }
}
