import {Injectable} from '@angular/core';
import {CrudService} from "../crud.service";
import {AuthHttp} from "angular2-jwt";
import {TreeNodeService} from "../common/tree-node.service";
import {Observable} from "rxjs/Observable";
import {MyTreeNode} from "../../models/my-tree-node.model";
import {CategoryService} from "../category-service";
import {ServiceConstants} from "../../../shared/service-constants";

@Injectable()
export class MedicalTestReportTemplateCategoryService extends CrudService<any> implements CategoryService {

  rootUrl: string = `${ServiceConstants.MEDICALTEST_URL}/report-category`;

  constructor(authHttp: AuthHttp, private treeNodeService: TreeNodeService) {
    super(`${ServiceConstants.MEDICALTEST_URL}/report-category`, authHttp);
  }

  getNodesByDepartmentId(dId:number): Observable<MyTreeNode[]> {
    return this.authHttp.get(`${this.rootUrl}/departmentId/${dId}`)
      .map(res => {
        return res.json().map(item => {
          return this.treeNodeService.treeConverter(item, true);
        });
      });
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
