import {CanActivate} from "@angular/router";
import {Injectable} from "@angular/core";
import {AbstractGuard} from "../../../shared/guards/abstract.guard";
import {AuthorizationService} from "../../services/common/authorization.service";

@Injectable()
export class FrontdeskGuard extends AbstractGuard implements CanActivate {

  constructor(authorizationService: AuthorizationService) {
    super("Treatment","前台服务","操作",authorizationService);
  }

  canActivate(): boolean {
    return true;
    //return this.isAuthorized();
  }
}
