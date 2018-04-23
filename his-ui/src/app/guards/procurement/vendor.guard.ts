import {CanActivate, Router} from "@angular/router";
import {Injectable} from "@angular/core";
import {Observable} from "rxjs/Observable";
import {AuthorizationService} from "../../services/common/authorization.service";

@Injectable()
export class VendorGuard implements CanActivate {

  private static TOPIC: string = "供应商";
  private static OPERATION: string = "管理";

  constructor(private authorizationService: AuthorizationService) {

  }

  canActivate(): boolean {
    return this.authorizationService
      .isAuthorized("Procurement",
        VendorGuard.TOPIC,
        VendorGuard.OPERATION);
  }
}
