import {Injectable} from '@angular/core';
import {AuthHttp} from "angular2-jwt";
import {Observable} from "rxjs/Observable";
import {TreatmentEmployeeModel} from "../../../treatment/models/treatment.employee.model";
import {BehaviorSubject} from "rxjs/BehaviorSubject";
import {ServiceConstants} from "../../../shared/service-constants";
import {CrudService} from "../crud.service";

@Injectable()
export class TreatmentEmployeeService extends CrudService<TreatmentEmployeeModel> {


  treatmentEmployeeSubject = new BehaviorSubject<TreatmentEmployeeModel>({} as TreatmentEmployeeModel);

  constructor(authHttp: AuthHttp) {
    super(`${ServiceConstants.TREATMENT_URL}/employees`, authHttp);
  }

  findByEmpId(empId: number): Observable<TreatmentEmployeeModel> {
    let url = `${this.rootUrl}/findByEmpId/${empId}`;
    return this.authHttp.get(url).map(this.extractData);
  }

  setCanBeRegisteredValue(treatmentEmployee: TreatmentEmployeeModel):Observable<any> {
    return this.authHttp.post(`${this.rootUrl}/setCanBeRegisteredValue`, treatmentEmployee).map(r => {
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
