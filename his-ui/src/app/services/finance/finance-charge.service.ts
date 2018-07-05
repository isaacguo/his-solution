import { Injectable } from '@angular/core';
import {AuthHttp} from "angular2-jwt";
import {CrudService} from "../crud.service";
import {TreeNodeService} from "../common/tree-node.service";

@Injectable()
export class FinanceChargeService  extends CrudService {


  rootUrl: string = "/api/hisfinance/charges";

  constructor(authHttp: AuthHttp,public treeNodeService:TreeNodeService) {
    super("/api/hisfinance/charges",authHttp);
  }


}
