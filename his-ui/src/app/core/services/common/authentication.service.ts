import {Injectable} from '@angular/core';
import {BehaviorSubject} from 'rxjs/BehaviorSubject';
import {Observable} from 'rxjs/Observable';
import {Response} from "@angular/http";
import 'rxjs/add/operator/map'
import {AuthHttp, JwtHelper} from "angular2-jwt";
import {Router} from "@angular/router";
import "rxjs/add/operator/catch";

@Injectable()
export class AuthenticationService {
  private authManager: BehaviorSubject<AuthInfo>
    = new BehaviorSubject(new AuthInfo(AuthState.LoggedOut, ""));
  private authInfo: AuthInfo;
  authChange: Observable<AuthInfo>;

  public decoded: any;
  private jwtHelper: JwtHelper;

  constructor(private router: Router, private authHttp: AuthHttp) {
    this.authChange = this.authManager.asObservable();

    this.jwtHelper = new JwtHelper();

    let s_token = sessionStorage.getItem("id_token");
    if (s_token) {
      this.decoded = this.jwtHelper.decodeToken(s_token);
      //this.setAuthState(new AuthInfo(AuthState.LoggedIn, this.decoded.sub));
      this.setAuthState(new AuthInfo(AuthState.LoggedIn, this.decoded.sub, this.decoded.isAdmin == 'true', this.decoded.isFinance == 'true'));
    }
  }

  login(username: string, password: string,returnUrl:string) {

    this.setAuthState(new AuthInfo(AuthState.Logging, ""));

    this.authHttp.post('/login', JSON.stringify({username: username, password: password}))
      .map((response: Response) => {

        let token = response.headers.get("authorization");
        if (token) {
          sessionStorage.setItem("id_token", token);
          this.decoded = this.jwtHelper.decodeToken(token);

          return true;
        }
        else {
          return false;
        }
      })
      .catch((error: any) => Observable.throw(error.json().error || 'Server error'))
      .subscribe(r => {
        if (r) {
          this.setAuthState(new AuthInfo(AuthState.LoggedIn, this.decoded.sub, this.decoded.isAdmin == 'true', this.decoded.isFinance == 'true'));
          //this.router.navigate(['/dashboard']);
          this.router.navigateByUrl(returnUrl);
        }
        else {
          this.setAuthState(new AuthInfo(AuthState.LoginFailed, ""));
        }
      }, (err) => {
        if (err === "Unauthorized")
          this.setAuthState(new AuthInfo(AuthState.LoginFailed, ""));
        else
          this.setAuthState(new AuthInfo(AuthState.ServerError, ""));
      })

  }

  logout(): void {
    this.decoded = null;
    sessionStorage.removeItem("id_token");
    this.setAuthState(new AuthInfo(AuthState.LoggedOut, ""));
  }

  emitAuthState(): void {
    this.authManager.next(this.authInfo);
  }

  private setAuthState(newAuthInfo: AuthInfo): void {
    this.authInfo = newAuthInfo;
    this.emitAuthState();
  }
}

export class AuthInfo {

  constructor(public authState: AuthState, public displayName: string, public isAdmin: boolean = false, public isFinance: boolean = false) {

  }

}

export const enum AuthState {
  LoggedIn,
  LoggedOut,
  Logging,
  LoginFailed,
  ServerError
}
