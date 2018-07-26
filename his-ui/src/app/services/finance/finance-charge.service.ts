import {Injectable} from '@angular/core';
import {CrudService} from "../crud.service";
import {AuthHttp} from "angular2-jwt";
import {TreeNodeService} from "../common/tree-node.service";
import {ChargeStatusEnum} from "../../enums/charge-status.enum";
import {Observable} from "rxjs/Observable";

@Injectable()
export class FinanceChargeService extends CrudService {

  rootUrl: string = "/api/hisfinance/charge";

  constructor(authHttp: AuthHttp, public treeNodeService: TreeNodeService) {
    super("/api/hisfinance/charges", authHttp);
  }

  updateStatus(id: number, status: string): Observable<boolean> {
    return this.authHttp.post(`${this.rootUrl}/${id}/updateStatus`, {'chargeStatus': status}).map(this.extractData);
  }


}
