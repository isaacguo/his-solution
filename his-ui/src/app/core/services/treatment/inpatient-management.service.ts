import {Injectable} from '@angular/core';
import {AuthHttp} from "angular2-jwt";
import {Observable} from "rxjs/Observable";
import {ServiceConstants} from "../../../shared/service-constants";
import {InpatientManagement} from "../../models/treatment/model.component";
import {CrudService} from "../crud.service";

@Injectable()
export class InpatientManagementService extends CrudService<InpatientManagement> {


  rootUrl: string = `${ServiceConstants.TREATMENT_URL}/inpatient-management`;

  constructor(authHttp: AuthHttp) {
    super(`${ServiceConstants.TREATMENT_URL}/inpatient-management`, authHttp);
  }

  getRecordsByStatus(status: String): Observable<InpatientManagement[]> {
    return this.authHttp.get(`${this.rootUrl}/${status}`).map(this.extractData);
  }

  createInpatientRecord(request: InpatientManagement): Observable<number> {
    return this.authHttp.post(this.rootUrl, request).map((r)=>r.status);
  }
}

