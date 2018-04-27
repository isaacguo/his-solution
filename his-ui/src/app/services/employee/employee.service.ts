import {Injectable} from "@angular/core";
import {Http, Headers, RequestOptions, Response, ResponseContentType} from '@angular/http';
import {Observable} from 'rxjs/Rx';
import {AuthHttp} from "angular2-jwt";
import {Employee} from "../../dto/employee.model";
import {EmployeeCount} from "../../dto/employee.count.model";
import {EmployeeListItem} from "../../dto/employee/employee-list-item.model";
import {DepartmentListItem} from "../../dto/employee/department-list-item.model";
import {AbstractService} from "../abstract.service";


@Injectable()
export class EmployeeService extends AbstractService {

  private rootUrl: string = "/api/hisemployee/employees";
  private deleteEmployeeUrl: string = `${this.rootUrl}/delete`;

  constructor(private authHttp: AuthHttp) {
    super();
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


  deleteEmployee(id: number | undefined): Observable<boolean> {
    return this.authHttp.delete(`${this.deleteEmployeeUrl}/${id}`).map(r => {
      return this.extractTextData(r) === "true" ? true : false;
    });
  }
}
