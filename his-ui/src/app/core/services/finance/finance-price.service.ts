import {Injectable} from '@angular/core';
import {AuthHttp} from "angular2-jwt";
import {CrudService} from "../crud.service";
import {TreeNodeService} from "../common/tree-node.service";
import {Observable} from "rxjs/Observable";
import {ServiceConstants} from "../../../shared/service-constants";

@Injectable()
export class FinancePriceService extends CrudService<any> {


  rootUrl: string = `${ServiceConstants.FINANCE_URL}/price`;

  constructor(authHttp: AuthHttp, public treeNodeService: TreeNodeService) {
    super(`${ServiceConstants.FINANCE_URL}/price`, authHttp);
  }

  findByUuids(list: any[]): Observable<any[]> {
    return this.authHttp.post(`${this.rootUrl}/findByUuids`, {'uuids': list}).map(this.extractData);
  }

  findByUuid(uuid: string): Observable<any> {
    return this.authHttp.get(`${this.rootUrl}/findByUuid/${uuid}`).map(this.extractData);
  }


  updateValue(request: any): Observable<any> {
    return this.authHttp.put(`${this.rootUrl}`, request).map(this.extractData);
  }
}
