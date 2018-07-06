import { Injectable } from '@angular/core';
import {CrudService} from "../crud.service";
import {CategoryService} from "../../components/common/abstract-category-list/category-service";
import {AuthHttp} from "angular2-jwt";
import {TreeNodeService} from "../common/tree-node.service";
import {Observable} from "rxjs/Observable";
import {MyTreeNode} from "../../dto/procurement/MyTreeNode";

@Injectable()
export class MedicalTestReportTemplateCategoryService  extends CrudService implements CategoryService{


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
