import { Injectable } from '@angular/core';
import {CrudService} from "../crud.service";
import {AuthHttp} from "angular2-jwt";
import {ServiceConstants} from "../../../shared/service-constants";
import {TreeNodeService} from "../common/tree-node.service";
import {Observable} from "rxjs/Observable";

@Injectable()
export class ChargeableItemService extends CrudService<any> {

  rootUrl: string = `${ServiceConstants.TREATMENT_URL}/chargeable-items`;

  constructor(authHttp: AuthHttp,private treeNodeService: TreeNodeService) {
    super(`${ServiceConstants.TREATMENT_URL}/chargeable-items`, authHttp);
  }


  deleteById(updateId: number):Observable<boolean> {
    return this.authHttp.delete(`${this.rootUrl}/${updateId}`).map(r => {
      return this.extractTextData(r) === "true" ? true : false;
    });
  }

}
