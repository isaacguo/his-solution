import {Component, OnDestroy, OnInit} from '@angular/core';
import {AuthenticationService, AuthInfo, AuthState} from "../../services/common/authentication.service";
import {Router} from "@angular/router";
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

  constructor(private router: Router, private authenticationService: AuthenticationService) {
    this.authChangeSubscription = authenticationService.authChange.subscribe(
      newAuthInfo =>
        this.authInfo = newAuthInfo);
  }

  ngOnInit() {
  }

  login(): void {
    this.authenticationService.login(this.username, this.password);
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
