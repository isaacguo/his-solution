import {Injectable} from '@angular/core';
import {ServiceConstants} from "../../../shared/service-constants";
import {CrudService} from "../crud.service";
import {AuthHttp} from "angular2-jwt";
import {Observable} from "rxjs/Observable";

@Injectable()
export class DataManagementService extends CrudService<any> {

  rootUrl: string = `${ServiceConstants.GATEWAY_URL}/data-management`;

  constructor(authHttp: AuthHttp) {
    super(`${ServiceConstants.GATEWAY_URL}/data-management`, authHttp);
  }

  backup(): Observable<any> {
    return this.authHttp.post(`${this.rootUrl}/backup`, {}).map(this.extractData);
  }

}
