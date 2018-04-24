import {Injectable} from '@angular/core';
import {DepartmentListItem} from "../../dto/employee/department-list-item.model";
import {Observable} from "rxjs/Rx";
import {AbstractService} from "../abstract.service";
import {AuthHttp} from "angular2-jwt";
import {of} from "rxjs/observable/of";
import {MyTreeNode} from "../../dto/procurement/MyTreeNode";
import 'rxjs/add/operator/map';


@Injectable()
export class EmployeeDepartmentService extends AbstractService {

  constructor(private authHttp: AuthHttp) {
    super();
  }

  private rootUrl: string = "/api/hisemployee/departments";
  private getDepartmentListUrl: string = "/api/hisemployee/departments/brief";

  private getRootDepartmentUrl: string = "/api/hisemployee/departments/root";


  getDepartmentList(): Observable<DepartmentListItem[]> {
    return this.authHttp.get(this.getDepartmentListUrl).map(this.extractData);
  }


  getRootDepartment(): Observable<MyTreeNode> {
    return this.authHttp.get(this.getRootDepartmentUrl)
      .map(res => {
        let m: MyTreeNode = this.treeConverter(res.json(), true);
        console.log(m);
        return m;
      });
  }

  treeConverter(json: any, isLevelOne: boolean): MyTreeNode {

    let node = new MyTreeNode();
    node.name = json.name;
    node.categoryId = json.id;
    node.isLevelOne = isLevelOne;

    if (json.children != null && json.children.length > 0) {
      node.children = [];
      for (let child of json.children) {
        node.children.push(this.treeConverter(child, false));
      }
    }

    console.log(node);
    return node;

  }

  deleteDepartment(categoryId: number | undefined): Observable<boolean> {

    return of(true);
  }

  createDepartment(value: any): Observable<boolean> {
    return of(true);
  }

  updateDepartmentName(departmentId: number | string[], value): Observable<boolean> {

    return of(true);
  }
}
