import { Injectable } from '@angular/core';
import {CategoryService} from "../../../shared/abstract-category-list/category-service";
import {CrudService} from "../crud.service";
import {TreeNodeService} from "../common/tree-node.service";
import {AuthHttp} from "angular2-jwt";
import {Observable} from "rxjs/Observable";
import {MyTreeNode} from "../../models/my-tree-node.model";
import {ServiceConstants} from "../../../shared/service-constants";

@Injectable()
export class ChargeableCategoryService extends CrudService<any> implements CategoryService {

  rootUrl: string = `${ServiceConstants.TREATMENT_URL}/chargeable-category`;

  constructor(authHttp: AuthHttp,private treeNodeService: TreeNodeService) {
    super(`${ServiceConstants.TREATMENT_URL}/chargeable-category`, authHttp);
  }

  getNodes(): Observable<MyTreeNode[]> {
    return this.authHttp.get(`${this.rootUrl}`)
      .map(res => {
        return res.json().map(item => {
          return this.treeNodeService.treeConverter(item, true);
        });
      });
  }


}
