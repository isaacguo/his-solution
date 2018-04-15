import {Injectable} from '@angular/core';
import {Observable} from "rxjs/Rx";
import {MyTreeNode} from "../../dto/procurement/MyTreeNode";
import {AuthHttp} from "angular2-jwt";
import {AbstractService} from "../abstract.service";
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/debounceTime';
import 'rxjs/add/operator/distinctUntilChanged';
import 'rxjs/add/operator/switchMap';
import 'rxjs/add/operator/do';
import {VendorCategory} from "../../dto/procurement/vendor-category.model";
import {VendorPermitDepartment} from "../../dto/employee/vendor-permit-department.model";

@Injectable()
export class VendorCategoryService extends AbstractService {

  rootUrl: string = "/api/hisprocurement/categories";
  private getListUrl: string = `${this.rootUrl}/list`;
  private updateDepartmentPermissionUrl: string = `${this.rootUrl}/updateDepartmentPermission`;

  constructor(private authHttp: AuthHttp) {
    super();
  }

  findVendorCategoryById(categoryId: number): Observable<VendorCategory> {
    return this.authHttp.get(`${this.rootUrl}/${categoryId}`).map(this.extractData);
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

    return node;

  }


  findAllForList(): Observable<MyTreeNode[]> {
    return this.authHttp.get(this.getListUrl)
      .map(res => {
        return res.json().map(item => {

          return this.treeConverter(item, true);

        });
      });
  }


  updateDepartmentPermission(id: number, departments: VendorPermitDepartment[]): Observable<boolean> {
    return this.authHttp.post(this.updateDepartmentPermissionUrl, {
      'id': id,
      'departments': departments
    }).map(r => {
      return this.extractTextData(r) === "true" ? true : false;
    });
  }
}
