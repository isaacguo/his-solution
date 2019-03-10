import {Injectable} from '@angular/core';
import {AuthHttp} from "angular2-jwt";
import {TreeNodeService} from "../common/tree-node.service";
import {Observable} from "rxjs/Observable";
import {MyTreeNode} from "../../models/my-tree-node.model";
import {CategoryService} from "../category-service";
import {CrudService} from "../crud.service";

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
