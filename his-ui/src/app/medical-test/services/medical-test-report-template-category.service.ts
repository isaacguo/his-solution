import {Injectable} from '@angular/core';
import {CrudService} from "../../core/services/crud.service";
import {AuthHttp} from "angular2-jwt";
import {TreeNodeService} from "../../core/services/common/tree-node.service";
import {Observable} from "rxjs/Observable";
import {MyTreeNode} from "../../core/models/my-tree-node.model";
import {CategoryService} from "../../shared/abstract-category-list/category-service";

@Injectable()
export class MedicalTestReportTemplateCategoryService  extends CrudService<any> implements CategoryService{


  rootUrl: string = "/api/hismedicaltest/report-category";


  constructor(authHttp: AuthHttp,private treeNodeService: TreeNodeService) {
    super("/api/hismedicaltest/report-category", authHttp);
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
