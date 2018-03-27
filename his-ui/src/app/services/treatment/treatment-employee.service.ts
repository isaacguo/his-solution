import {Injectable} from '@angular/core';
import {AuthHttp} from "angular2-jwt";
import {AbstractService} from "../abstract.service";
import {Observable} from "rxjs/Observable";
import {Department} from "../../dto/department.model";
import {TreatmentEmployeeModel} from "../../dto/treatment.employee.model";

@Injectable()
export class TreatmentEmployeeService extends AbstractService {

  rootUrl: string = "/api/histreatment/employees";

  constructor(private authHttp: AuthHttp) {
    super();
  }


  findByEmployeeType(employeeTypeId:number): Observable<TreatmentEmployeeModel> {
    let url = `${this.rootUrl}/find-by-employee-type`;
    return this.authHttp.post(url, JSON.stringify({employeeTypeId: employeeTypeId})).map(this.extractData);
  }

  findByDepartment(departmentId:number): Observable<TreatmentEmployeeModel[]> {
    let url = `${this.rootUrl}/find-by-department`;
   return this.authHttp.post(url,JSON.stringify({departmentId: departmentId})).map(this.extractData);
  }


}
