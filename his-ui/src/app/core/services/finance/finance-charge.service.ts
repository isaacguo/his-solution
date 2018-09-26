import {Injectable} from '@angular/core';
import {CrudService} from "../crud.service";
import {AuthHttp} from "angular2-jwt";
import {TreeNodeService} from "../common/tree-node.service";
import {Observable} from "rxjs/Observable";
import {ServiceConstants} from "../../../shared/service-constants";

@Injectable()
export class FinanceChargeService extends CrudService<any> {

  rootUrl: string = `${ServiceConstants.FINANCE_URL}/charge`;

  constructor(authHttp: AuthHttp, public treeNodeService: TreeNodeService) {
    super(`${ServiceConstants.FINANCE_URL}/charge`, authHttp);
  }

  updateStatus(id: number, status: string): Observable<boolean> {
    return this.authHttp.post(`${this.rootUrl}/${id}/updateStatus`, {'chargeStatus': status}).map(r => {
      return this.extractTextData(r) === "true" ? true : false;
    });
  }

}
