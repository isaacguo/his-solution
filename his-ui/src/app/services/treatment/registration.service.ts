import {Injectable} from '@angular/core';
import {AbstractService} from "../abstract.service";
import {AuthHttp} from "angular2-jwt";

@Injectable()
export class RegistrationService extends AbstractService {

  rootUrl: string = "/api/histreatment/owners";

  constructor(private authHttp: AuthHttp) {
    super();
  }

}
