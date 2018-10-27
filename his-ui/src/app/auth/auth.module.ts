import {NgModule} from '@angular/core';
import {LoginComponent} from "./components/login/login.component";
import {LogoutComponent} from "./components/logout/logout.component";
import {SharedModule} from "../shared/shared.module";
import {AuthRoutingModule} from "./auth-routing.module";
import {AuthGuard} from "./guards/auth.guard";
import {LogoutGuard} from "./guards/logout.guard";

@NgModule({
  imports: [
    SharedModule,
    AuthRoutingModule
  ],
  declarations: [LoginComponent,
    LogoutComponent],
  providers:[
    AuthGuard,
    LogoutGuard
  ]
})
export class AuthModule {
}
