import {NgModule} from '@angular/core';

import {CoreRoutingModule} from './core-routing.module';
import {AuthenticationService} from "./services/common/authentication.service";
import {AuthorizationService} from "./services/common/authorization.service";
import {Http, RequestOptions} from "@angular/http";
import {AuthConfig, AuthHttp} from "angular2-jwt";
import {SharedModule} from "../shared/shared.module";


export function authHttpServiceFactory(http: Http, options: RequestOptions) {
  return new AuthHttp(new AuthConfig({
    headerName: "Authorization",
    headerPrefix: "Bearer",
    tokenName: "id_token",
    tokenGetter: (() => sessionStorage.getItem("id_token")),
    globalHeaders: [{'Content-Type': 'application/json'}],
    noJwtError: true,
    noTokenScheme: true
  }), http, options);
}

@NgModule({
  imports: [
    SharedModule,
    CoreRoutingModule
  ],
  declarations: [],
  providers: [
    {
      provide: AuthHttp, useFactory: authHttpServiceFactory, deps: [Http, RequestOptions]
    },
    AuthorizationService,
    AuthenticationService,
  ]
})
export class CoreModule {
}
