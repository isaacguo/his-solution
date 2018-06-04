import {CanActivate, Router} from "@angular/router";
import {Injectable, OnDestroy} from "@angular/core";
import {Observable} from "rxjs/Observable";
import {Subscription} from "rxjs/Subscription";
import {AbstractGuard} from "../abstract.guard";
import {AuthorizationService} from "../../services/common/authorization.service";

@Injectable()
export class MedicalTestManagementGuard extends AbstractGuard implements CanActivate {

  constructor(authorizationService: AuthorizationService) {
    super("MedicalTest","化验管理","操作",authorizationService);
  }

  canActivate(): boolean {
    return this.isAuthorized();
  }
}
