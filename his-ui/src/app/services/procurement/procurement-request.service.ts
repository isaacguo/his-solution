import {Injectable} from '@angular/core';
import {Observable} from "rxjs/Observable";
import {AuthHttp} from "angular2-jwt";
import {ProcurementStatus} from "../../dto/procurement/procurement-status.model";
import {AbstractService} from "../abstract.service";
import {Vendor} from "../../dto/procurement/vendor.model";
import {ProcurementRequest} from "../../dto/procurement/procurement-request.model";
import {FormGroup} from "@angular/forms";

@Injectable()
export class ProcurementRequestService extends AbstractService {


  rootUrl: string = "/api/hisprocurement/procurement-request";
  createRequestUrl: string = `${this.rootUrl}/create`;

  //private procurementStatusRootUrl: string = `${this.rootUrl}/`;

  constructor(private authHttp: AuthHttp) {
    super();
  }

  createRequest(request: FormGroup): Observable<boolean> {
    return this.authHttp.post(this.createRequestUrl, request).map(r => {
      return this.extractTextData(r) === "true" ? true : false;
    });
  }
}
