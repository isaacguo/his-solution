import {Injectable} from '@angular/core';
import {CanActivate} from '@angular/router';
import {AbstractGuard} from "../../../shared/guards/abstract.guard";
import {AuthorizationService} from "../../services/common/authorization.service";

@Injectable()
export class PriceManagementGuard extends AbstractGuard implements CanActivate {

  constructor(authorizationService: AuthorizationService) {
    super("Finance", "收费定价", "操作", authorizationService);
  }

  canActivate(): boolean {
    return this.isAuthorized();
  }
}
