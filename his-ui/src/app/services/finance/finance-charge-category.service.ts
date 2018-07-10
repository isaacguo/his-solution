import {Injectable} from '@angular/core';
import {CrudService} from "../crud.service";
import {AuthHttp} from "angular2-jwt";
import {Observable} from "../../../../node_modules/rxjs";
import {MyTreeNode} from "../../dto/procurement/MyTreeNode";
import {TreeNodeService} from "../common/tree-node.service";
import {CategoryService} from "../../components/common/abstract-category-list/category-service";
import {AuthorizationService} from "../common/authorization.service";

@Injectable()
export class FinanceChargeCategoryService extends CrudService implements CategoryService {


  rootUrl: string = "/api/hisfinance/charge-categories";

  mappingUrl: string = "/charge-items";

  chargableServiceArray: [string, string][] = [];


  constructor(authHttp: AuthHttp, public treeNodeService: TreeNodeService,
              private authorizationService: AuthorizationService) {
    super("/api/hisfinance/charge-categories", authHttp);

    this.chargableServiceArray.push(["化验模块", "/api/hismedicaltest"]);

    //this.chargableServiceArray.push(["库房模块", "/api/hismedicine"]);
  }

  getRootChargeCategory(): Observable<MyTreeNode[]> {
    return this.authHttp.get(`${this.rootUrl}/root`)
      .map(res => {
        return res.json().map(item => {
          return this.treeNodeService.treeConverter(item, true);
        });
      });
  }

  renameChargeCategory(categoryId: number, value: any): Observable<boolean> {
    return this.authHttp.put(`${this.rootUrl}/rename`, {'name': value, 'id': categoryId}).map(r => {
      return this.extractTextData(r) === "true" ? true : false;
    });
  }

  getNodes(): Observable<any> {
    return Observable.empty();
  }

}
