import {Injectable} from '@angular/core';
import {CanActivate} from '@angular/router';
import {AuthorizationService} from "../../core/services/common/authorization.service";
import {AbstractGuard} from "../../shared/guards/abstract.guard";

@Injectable()
export class ChargeManagementGuard extends AbstractGuard  implements CanActivate {

  constructor(authorizationService: AuthorizationService) {
    super("Finance","收费定价","操作",authorizationService);
  }

  canActivate(): boolean {
    return this.isAuthorized();
  }
}
