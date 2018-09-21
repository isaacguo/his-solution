import {Injectable} from '@angular/core';
import {CrudService} from "../crud.service";
import {AuthHttp} from "angular2-jwt";
import {TreeNodeService} from "../common/tree-node.service";
import {Observable} from "rxjs/Observable";
import {CategoryService} from "../../../shared/abstract-category-list/category-service";
import {MyTreeNode} from "../../models/my-tree-node.model";

@Injectable()
export class InventoryCategoryService extends CrudService<any> implements CategoryService {

  rootUrl: string = "/api/hismedicine/inventory-categories";

  constructor(authHttp: AuthHttp, private treeNodeService: TreeNodeService) {
    super("/api/hismedicine/inventory-categories", authHttp);
  }

  getNodes(): Observable<MyTreeNode[]> {
    return this.authHttp.get(`${this.rootUrl}/roots`)
      .map(res => {
        return res.json().map(item => {
          return this.treeNodeService.treeConverter(item, true);
        });
      });
  }

}
