import {CanActivate} from "@angular/router";
import {Injectable} from "@angular/core";
import {AuthorizationService} from "../../services/common/authorization.service";
import {GuardDelegation} from "../guard-delegation";
import {Observable} from "rxjs/Observable";

@Injectable()
export class TreatmentSettingsGuard extends GuardDelegation implements CanActivate {

  constructor(authorizationService: AuthorizationService) {
    super("Treatment", "就诊设置", "操作", authorizationService);
  }

  canActivate(): Observable<boolean> {
    return this.isAuthorized();
  }
}
