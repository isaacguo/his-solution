import { Injectable } from '@angular/core';
import {AbstractService} from "../abstract.service";
import {Observable} from "rxjs/Rx";
import {Department} from "../../dto/treatment/department.model";
import {DepartmentOperationRequest} from "../../dto/treatment/department.operation.request.model";
import {TreeNodeService} from "../common/tree-node.service";
import {TreatmentEmployeeModel} from "../../dto/treatment/treatment.employee.model";
import {AuthHttp} from "angular2-jwt";

@Injectable()
export class MedicalTestDepartmentService extends AbstractService  {

  rootUrl: string = "/api/hismedicaltest/departments";

  constructor(private authHttp: AuthHttp, private treeNodeService: TreeNodeService) {
    super();
  }

  getDepartments(): Observable<any[]> {

    return this.authHttp.get(`${this.rootUrl}`)
      .map(this.extractData);
  }


  getDepartmentByDepId(depId: number): Observable<any> {
    let url = `${this.rootUrl}/getDepartmentByDepId/${depId}/`;
    return this.authHttp.get(url)
      .map(this.extractData);

  }

  setDepartmentEnable(departmentId: number, departmentName: string, state: boolean): Observable<boolean> {

    let request:any={};
    request.enable = state;
    request.name = departmentName;
    request.depId = departmentId;

    let url = `${this.rootUrl}/setDepartmentEnable`;
    return this.authHttp.post(url, request).map(r => {
      return this.extractTextData(r) === "true" ? true : false;
    });
  }

}
