import {Injectable} from "@angular/core";
import {Http, Headers, RequestOptions, Response, ResponseContentType} from '@angular/http';
import {Observable} from 'rxjs/Rx';
import {AuthHttp} from "angular2-jwt";
import {Employee} from "../../dto/employee.model";
import {EmployeeCount} from "../../dto/employee.count.model";
import {EmployeeListItem} from "../../dto/employee/employee-list-item.model";
import {DepartmentListItem} from "../../dto/employee/department-list-item.model";


@Injectable()
export class EmployeeService {

  rootUrl: string = "/api/hisemployee/employees";

  constructor(private authHttp: AuthHttp) {
  }

  getEmployeeCount(): Observable<EmployeeCount> {
    let url = `/api/hisemployee/employees/counts`;
    return this.authHttp.get(url).map(this.extractData);
  }

  getEmployees(): Observable<Employee[]> {

    let url = `/api/hisemployee/employees`;
    return this.authHttp.get(url)
      .map(this.extractData);
  }

  findEmployeesByNameContains(keyword: string): Observable<Employee[]> {

    let url = `${this.rootUrl}/search-by-name/${keyword}`;

    return this.authHttp.get(url).map(this.extractData);
  }

  getMyInfo(): Observable<Employee> {
    let url = `/api/hisemployee/employees/getMyInfo`;
    return this.authHttp.get(url)
      .map(this.extractData);
  }

  getEmployeeInfoByEmployeeUuid(uuid: string): Observable<Employee> {
    let url = `/api/hisemployee/employees/${uuid}/`;
    return this.authHttp.get(url)
      .map(this.extractData);
  }

  getEmployeeListByDepartmentId(departmentId: number): Observable<EmployeeListItem[]> {
    let url = `/api/hisemployee/employees/${departmentId}/employee-list`;
    return this.authHttp.get(url)
      .map(this.extractData);
  }


  private extractData(res: Response) {
    let body = res.json();
    return body || {};
  }

  private handleError(error: Response | any) {
    // In a real world app, we might use a remote logging infrastructure
    let errMsg: string;
    if (error instanceof Response) {
      const body = error.json() || '';
      const err = body.error || JSON.stringify(body);
      errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
    } else {
      errMsg = error.message ? error.message : error.toString();
    }
    console.error(errMsg);
    return Observable.throw(errMsg);
  }

}
