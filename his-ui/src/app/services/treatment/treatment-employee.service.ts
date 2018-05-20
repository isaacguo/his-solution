import {Injectable} from '@angular/core';
import {AuthHttp} from "angular2-jwt";
import {AbstractService} from "../abstract.service";
import {Observable} from "rxjs/Observable";
import {TreatmentEmployeeModel} from "../../dto/treatment/treatment.employee.model";

@Injectable()
export class TreatmentEmployeeService extends AbstractService {

  rootUrl: string = "/api/histreatment/employees";

  constructor(private authHttp: AuthHttp) {
    super();
  }


  findByEmpId(empId: number): Observable<TreatmentEmployeeModel> {
    let url = `${this.rootUrl}/findByEmpId/${empId}`;
    return this.authHttp.get(url).map(this.extractData);
  }

  setCanBeRegisteredValue(treatmentEmployee: TreatmentEmployeeModel) {

    let url = `${this.rootUrl}/setCanBeRegisteredValue`;
    return this.authHttp.post(url, treatmentEmployee).map(r => {
      return this.extractTextData(r) === "true" ? true : false;
    });
  }

  findByEmployeeType(employeeTypeId: number): Observable<TreatmentEmployeeModel> {
    let url = `${this.rootUrl}/find-by-employee-type`;
    return this.authHttp.post(url, JSON.stringify({employeeTypeId: employeeTypeId})).map(this.extractData);
  }

  findByDepartmentAndCanBeRegisteredIsTrue(departmentId: number): Observable<TreatmentEmployeeModel[]> {
    let url = `${this.rootUrl}/find-by-department-and-can-be-registered`;
    return this.authHttp.post(url, JSON.stringify({departmentId: departmentId})).map(this.extractData);
  }
}
