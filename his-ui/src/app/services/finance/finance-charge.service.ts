import { Injectable } from '@angular/core';
import {CrudService} from "../crud.service";
import {AuthHttp} from "angular2-jwt";
import {TreeNodeService} from "../common/tree-node.service";

@Injectable()
export class FinanceChargeService extends CrudService {

  rootUrl: string = "/api/hisfinance/charge";

  constructor(authHttp: AuthHttp, public treeNodeService: TreeNodeService) {
    super("/api/hisfinance/charges", authHttp);
  }



}
