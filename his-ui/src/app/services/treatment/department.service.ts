import {Injectable} from "@angular/core";
import {Headers, RequestOptions, Response} from '@angular/http';
import {Observable} from 'rxjs/Rx';
import {AuthHttp} from "angular2-jwt";
import {Department} from "../../dto/treatment/department.model";
import {MyTreeNode} from "../../dto/procurement/MyTreeNode";
import {TreeNodeService} from "../common/tree-node.service";
import {DepartmentOperationRequest} from "../../dto/treatment/department.operation.request.model";
import {AbstractService} from "../abstract.service";
import {TreatmentEmployeeModel} from "../../dto/treatment/treatment.employee.model";

@Injectable()
export class DepartmentService extends AbstractService {


  rootUrl: string = "/api/histreatment/departments";

  constructor(private authHttp: AuthHttp, private treeNodeService: TreeNodeService) {
    super();
  }

  getDepartments(): Observable<Department[]> {

    //let url = `/api/histreatment/departments`;
    return this.authHttp.get(`${this.rootUrl}`)
      .map(this.extractData);
  }


  /*
    getDoctorsInDepartmentByUuid(uuid: string): Observable<Doctor[]> {
      let url = `/api/histreatment/departments/getDoctorsInDepartmentByUuid/${uuid}/`;
      return this.authHttp.get(url)
        .map(this.extractData);
    }
    createTreatmentCase(treatmentCase: TreatmentCase): Observable<TreatmentCase> {

      let url = `${this.rootUrl}/book`;
      let options = this.getOptions();

      return this.authHttp.post(url, treatmentCase, options)
        .map(this.extractData)
        .catch((error: any) => Observable.throw(error.json().error || 'Server error'));

    }
    */

  getDepartmentByDepId(depId: number): Observable<Department> {
    let url = `${this.rootUrl}/getDepartmentByDepId/${depId}/`;
    return this.authHttp.get(url)
      .map(this.extractData);

  }

  setDepartmentOpenToFrontDeskValue(departmentId: number, departmentName: string, state: boolean): Observable<boolean> {

    const request: DepartmentOperationRequest = new DepartmentOperationRequest();
    request.openToFrontDesk = state;
    request.name = departmentName;
    request.depId = departmentId;

    let url = `${this.rootUrl}/setDepartmentOpenToFrontDeskValue`;
    return this.authHttp.post(url, request).map(r => {
      return this.extractTextData(r) === "true" ? true : false;
    });
  }


  getEmployeeListByDepartmentId(departmentId: string): Observable<TreatmentEmployeeModel[]> {
    let url = `${this.rootUrl}/getEmployeesByDepartmentId/${departmentId}`;
    return this.authHttp.get(url).map(this.extractData);
  }


}
