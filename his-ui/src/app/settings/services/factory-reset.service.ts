import {Injectable} from '@angular/core';
import {AuthHttp} from "angular2-jwt";
import {AbstractService} from "../../core/services/abstract.service";
import {Observable} from "rxjs/Observable";
import {AuthorizationService} from "../../core/services/common/authorization.service";

@Injectable()
export class FactoryResetService extends AbstractService {

  serviceArray: [string, string][] = [];

  constructor(private authHttp: AuthHttp, public authorizationService:AuthorizationService) {
    super();

  }


  resetService(serviceUrl: string):Observable<boolean> {
    return this.authHttp.post(`${serviceUrl}/factory-reset`,'').map(r => {
      return this.extractTextData(r) === "true" ? true : false;
    });
  }

  fillDemoData(serviceUrl: string) {
    return this.authHttp.post(`${serviceUrl}/factory-reset/fillDemoData`,'').map(r => {
      return this.extractTextData(r) === "true" ? true : false;
    });
  }
}
