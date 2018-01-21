import {Injectable, OnDestroy} from '@angular/core';
import {Router, CanActivate} from '@angular/router';
import {AuthenticationService, AuthState} from "../services/common/authentication.service";
import {Subscription} from "rxjs/Subscription";
import {Observable} from "rxjs/Observable";
import "rxjs/add/operator/take";

@Injectable()
export class AuthGuard implements CanActivate {


  constructor(private authenticationService: AuthenticationService, private router: Router) {

  }

  canActivate(): Observable<boolean> {
    return this.authenticationService.authChange.map(
      authInfo => {
        if (authInfo.authState != AuthState.LoggedIn)
          this.router.navigate((['/login']));
        else
          return true;
      }).take(1);
  }


}

@Injectable()
export class LogoutGuardService implements CanActivate {
  constructor(private authenticationService: AuthenticationService,
              private router: Router) {
  }

  canActivate(): boolean {
    this.authenticationService.logout();
    this.router.navigate(['/login']);
    return true;
  }
}
