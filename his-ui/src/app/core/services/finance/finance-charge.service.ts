import {Injectable} from '@angular/core';
import {CrudService} from "../crud.service";
import {AuthHttp} from "angular2-jwt";
import {TreeNodeService} from "../common/tree-node.service";
import {Observable} from "rxjs/Observable";

@Injectable()
export class FinanceChargeService extends CrudService<any> {

  rootUrl: string = "/api/hisfinance/charge";

  constructor(authHttp: AuthHttp, public treeNodeService: TreeNodeService) {
    super("/api/hisfinance/charges", authHttp);
  }

  updateStatus(id: number, status: string): Observable<boolean> {
    return this.authHttp.post(`${this.rootUrl}/${id}/updateStatus`, {'chargeStatus': status}).map(r => {
      return this.extractTextData(r) === "true" ? true : false;
    });
  }


}
