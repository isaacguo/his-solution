import {Component, OnDestroy, OnInit} from '@angular/core';
import {AuthenticationService, AuthInfo} from "../../services/common/authentication.service";
import {Subscription} from "rxjs/Subscription";

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css']
})
export class IndexComponent implements OnInit, OnDestroy {

  authInfo: AuthInfo;
  private authChangeSubscription: Subscription;

  ngOnDestroy(): void {
    this.authChangeSubscription.unsubscribe();
  }


  constructor(private authenticationService: AuthenticationService) {
    this.authChangeSubscription = authenticationService.authChange.subscribe(
      newAuthInfo =>
        this.authInfo = newAuthInfo);
  }


  ngOnInit() {
  }

  onLoginBtnClicked() {
  }

}
