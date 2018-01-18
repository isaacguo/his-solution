import {Component, OnInit} from '@angular/core';
import {AuthenticationService} from "../../services/common/authentication.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {


  public username: string;
  public password: string;


  constructor(private router: Router, private authenticationService: AuthenticationService) {

  }


  ngOnInit() {
  }

  login(): void {
    this.authenticationService.login(this.username, this.password);
  }

  onLoginBtnClicked() {
    this.login();

  }
}
