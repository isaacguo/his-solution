import {Injectable} from '@angular/core';
import {DepartmentListItem} from "../../dto/employee/department-list-item.model";
import {Observable} from "rxjs/Rx";
import {AbstractService} from "../abstract.service";
import {AuthHttp} from "angular2-jwt";
import {of} from "rxjs/observable/of";
import {MyTreeNode} from "../../dto/procurement/MyTreeNode";
import 'rxjs/add/operator/map';
import {TreeNodeService} from "../common/tree-node.service";


@Injectable()
export class EmployeeDepartmentService extends AbstractService {

  constructor(private authHttp: AuthHttp,public treeNodeService:TreeNodeService) {
    super();
  }

  private rootUrl: string = "/api/hisemployee/departments";
  private getDepartmentListUrl: string = "/api/hisemployee/departments/brief";

  private getRootDepartmentUrl: string = "/api/hisemployee/departments/root";
  private createDepartmentUrl: string = "/api/hisemployee/departments/create-department";
  private deleteDepartmentUrl: string = "/api/hisemployee/departments/delete-department";
  private renameDepartmentUrl: string = "/api/hisemployee/departments/rename-department";


  getDepartmentList(): Observable<DepartmentListItem[]> {
    return this.authHttp.get(this.getDepartmentListUrl).map(this.extractData);
  }


  getRootDepartment(): Observable<MyTreeNode> {
    return this.authHttp.get(this.getRootDepartmentUrl)
      .map(res => {
        let m: MyTreeNode = this.treeNodeService.treeConverter(res.json(), true);
        return m;
      });
  }



  deleteDepartment(id: number | undefined): Observable<boolean> {
    return this.authHttp.delete(`${this.deleteDepartmentUrl}/${id}`).map(r => {
      return this.extractTextData(r) === "true" ? true : false;
    });
  }

  createDepartment(parentId: number, name: string): Observable<boolean> {
    return this.authHttp.post(this.createDepartmentUrl, {'name': name, 'parentId': parentId}).map(r => {
      return this.extractTextData(r) === "true" ? true : false;
    });
  }

  renameDepartment(id: number, name: string): Observable<boolean> {
    return this.authHttp.put(this.renameDepartmentUrl, {'name': name, 'id': id}).map(r => {
      return this.extractTextData(r) === "true" ? true : false;
    });
  }
  findManager(depId: number): Observable<any> {
    let url = `${this.rootUrl}/find-manager/${depId}`;
    return this.authHttp.get(url).map(this.extractData);
  }


}
