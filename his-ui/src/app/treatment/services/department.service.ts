import {Injectable} from "@angular/core";
import {Observable} from 'rxjs/Rx';
import {AuthHttp} from "angular2-jwt";
import {TreeNodeService} from "../../core/services/common/tree-node.service";
import {AbstractService} from "../../core/services/abstract.service";
import {Department} from "../models/department.model";
import {TreatmentEmployeeModel} from "../models/treatment.employee.model";
import {DepartmentOperationRequest} from "../models/department.operation.request.model";

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

    let request: DepartmentOperationRequest = {
      openToFrontDesk: state,
      name: departmentName,
      depId: departmentId
    }

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
