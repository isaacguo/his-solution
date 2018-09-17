import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot} from '@angular/router';
import {Observable} from "rxjs/Observable";
import "rxjs/add/operator/take";
import {AuthorizationService} from "../../core/services/common/authorization.service";
import {AuthenticationService, AuthState} from "../../core/services/common/authentication.service";

@Injectable()
export class AuthGuard implements CanActivate {


  //must import AuthorizationService
  constructor(private authorizationService: AuthorizationService, private authenticationService: AuthenticationService, private router: Router) {

  }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean> {
    return this.authenticationService.authChange.map(
      authInfo => {
        if (authInfo.authState != AuthState.LoggedIn)
          this.router.navigate(['login'], {queryParams: {returnUrl: state.url}});
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
