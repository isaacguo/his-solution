import {Component, OnDestroy, OnInit} from '@angular/core';
import {AuthenticationService, AuthInfo, AuthState} from "../../services/common/authentication.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Subscription} from "rxjs/Subscription";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit, OnDestroy {

  ngOnDestroy(): void {
    this.authChangeSubscription.unsubscribe();
  }

  private authInfo: AuthInfo;
  private authChangeSubscription: Subscription;
  public username: string;
  public password: string;
  returnUrl:string;

  constructor(private route:ActivatedRoute,private router: Router, private authenticationService: AuthenticationService) {
    this.authChangeSubscription = authenticationService.authChange.subscribe(
      newAuthInfo =>
        this.authInfo = newAuthInfo);
  }

  ngOnInit() {
    this.returnUrl=this.route.snapshot.queryParams['returnUrl'] || '/';
  }

  login(): void {
    this.authenticationService.login(this.username, this.password, this.returnUrl);
  }

  onLoginBtnClicked() {
    this.login();
  }

  isLogging(): boolean {
    return this.authInfo.authState === AuthState.Logging;
  }

  isLogginFailed() {
    return this.authInfo.authState === AuthState.LoginFailed;
  }

  isServerError() {
    return this.authInfo.authState === AuthState.ServerError;
  }
}
