import {Injectable} from '@angular/core';
import {CanActivate, Router} from '@angular/router';
import {AuthenticationService} from "../../core/services/common/authentication.service";

@Injectable()
export class LogoutGuard implements CanActivate {
  constructor(private authenticationService: AuthenticationService,
              private router: Router) {
  }

  canActivate(): boolean {
    this.authenticationService.logout();
    this.router.navigate(['login']);
    return true;
  }
}
