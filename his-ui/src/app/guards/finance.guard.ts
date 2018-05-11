import {Injectable, OnDestroy} from '@angular/core';
import {Router, CanActivate} from '@angular/router';
import {AuthenticationService, AuthState} from "../services/common/authentication.service";
import {Subscription} from "rxjs/Subscription";
import {Observable} from "rxjs/Observable";
import "rxjs/add/operator/take";

@Injectable()
export class FinanceGuard implements CanActivate {


  constructor(private authenticationService: AuthenticationService, private router: Router) {

  }

  canActivate(): Observable<boolean> {
    return this.authenticationService.authChange.map(
      authInfo => {
        if (authInfo.isFinance)
          return true;
        else
          return false;
      }).take(1);
  }


}
