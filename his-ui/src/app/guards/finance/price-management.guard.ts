import {Injectable} from '@angular/core';
import {CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot} from '@angular/router';
import {Observable} from 'rxjs/Observable';
import {AuthorizationService} from "../../services/common/authorization.service";
import {AbstractGuard} from "../abstract.guard";

@Injectable()
export class PriceManagementGuard extends AbstractGuard implements CanActivate {

  constructor(authorizationService: AuthorizationService) {
    super("Finance", "收费定价", "操作", authorizationService);
  }

  canActivate(): boolean {
    return this.isAuthorized();
  }
}
