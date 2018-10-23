import {Injectable} from "@angular/core";
import {Observable} from 'rxjs/Rx';
import {AuthHttp} from "angular2-jwt";
import {TreeNodeService} from "../common/tree-node.service";
import {Department} from "../../../treatment/models/department.model";
import {TreatmentEmployeeModel} from "../../../treatment/models/treatment.employee.model";
import {DepartmentOperationRequest} from "../../../treatment/models/department.operation.request.model";
import {CrudService} from "../crud.service";
import {ServiceConstants} from "../../../shared/service-constants";

@Injectable()
export class TreatmentDepartmentService extends CrudService<Department> {

  rootUrl: string = `${ServiceConstants.TREATMENT_URL}/departments`;

  constructor(authHttp: AuthHttp, private treeNodeService: TreeNodeService) {
    super(`${ServiceConstants.TREATMENT_URL}/departments`, authHttp);
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


  getDepartmentByDepId(depId: number, depName: string): Observable<Department> {
    let url = `${this.rootUrl}/getDepartmentByDepId/${depId}/`;
    return this.authHttp.get(url).map(this.extractData).map(data => {
      return {...data, name: depName}
    });
  }

  setDepartmentOpenToFrontDeskValue(request: DepartmentOperationRequest): Observable<any> {
    return this.authHttp.post(`${this.rootUrl}/setDepartmentOpenToFrontDeskValue`, request).map(this.extractData);
  }


  getEmployeeListByDepartmentId(departmentId: string): Observable<TreatmentEmployeeModel[]> {
    let url = `${this.rootUrl}/getEmployeesByDepartmentId/${departmentId}`;
    return this.authHttp.get(url).map(this.extractData);
  }


}
