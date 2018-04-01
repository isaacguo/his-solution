import {Injectable} from '@angular/core';
import {AbstractService} from "../abstract.service";
import {AuthHttp} from "angular2-jwt";
import {Observable} from "rxjs/Observable";
import {ProcurementStatus} from "../../dto/procurement/procurement-status.model";

@Injectable()
export class ProcurementStatusService extends AbstractService {


  rootUrl: string = "/api/hisprocurement/procurement-status";
  private procurementStatusRootUrl: string = `${this.rootUrl}/root`;

  constructor(private authHttp: AuthHttp) {
    super();
  }

  getRoot(): Observable<ProcurementStatus> {
    return this.authHttp.get(this.procurementStatusRootUrl).map(this.extractData);
  }

}
