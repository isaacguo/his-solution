import {Injectable} from '@angular/core';
import {CanActivate, Router} from '@angular/router';
import {Observable} from "rxjs/Observable";
import "rxjs/add/operator/take";
import {AuthenticationService} from "../../core/services/common/authentication.service";

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
