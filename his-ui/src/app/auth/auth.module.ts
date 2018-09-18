import {NgModule} from '@angular/core';

import {AuthRoutingModule} from './auth-routing.module';
import {LoginComponent} from "./components/login/login.component";
import {LogoutComponent} from "./components/logout/logout.component";
import {SharedModule} from "../shared/shared.module";

@NgModule({
  imports: [
    SharedModule,
    AuthRoutingModule
  ],
  declarations: [
    LoginComponent,
    LogoutComponent
  ],
  providers:[

  ],
  exports:
  [
    LoginComponent,
    LogoutComponent
  ]
})
export class AuthModule { }
