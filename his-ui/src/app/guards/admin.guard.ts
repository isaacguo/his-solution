import {Injectable, OnDestroy} from '@angular/core';
import {Router, CanActivate} from '@angular/router';
import {AuthenticationService, AuthState} from "../services/common/authentication.service";
import {Subscription} from "rxjs/Subscription";
import {Observable} from "rxjs/Observable";
import "rxjs/add/operator/take";

@Injectable()
export class AdminGuard implements CanActivate {


  constructor(private authenticationService: AuthenticationService, private router: Router) {

  }

  canActivate(): Observable<boolean> {
    return this.authenticationService.authChange.map(
      authInfo => {
        if (authInfo.isAdmin)
          return true;
        else
          return false;
      }).take(1);
  }


}
