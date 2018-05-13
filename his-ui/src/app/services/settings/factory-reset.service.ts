import { Injectable } from '@angular/core';
import {AuthHttp} from "angular2-jwt";
import {AbstractService} from "../abstract.service";
import {Observable} from "rxjs/Observable";

@Injectable()
export class FactoryResetService extends AbstractService {

  serviceArray: [string, string][] = [];

  constructor(private authHttp: AuthHttp) {
    super();
    this.serviceArray.push(["/api/hisprocurement", "采购模块"]);
    this.serviceArray.push(["/api/hisemployee", "人事模块"]);
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
