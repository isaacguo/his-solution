import {CanActivate} from "@angular/router";
import {Injectable} from "@angular/core";
import {AuthorizationService} from "../../services/common/authorization.service";
import {GuardDelegation} from "../guard-delegation";
import {Observable} from "rxjs/Observable";

@Injectable()
export class FrontdeskGuard extends GuardDelegation implements CanActivate {

  constructor(authorizationService: AuthorizationService) {
    super("Treatment","前台服务","操作",authorizationService);
  }

  canActivate():Observable<boolean> {
    return Observable.of(true);
    //return this.isAuthorized();
  }
}
