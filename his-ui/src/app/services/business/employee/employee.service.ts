import {Injectable} from "@angular/core";
import {Http, Headers, RequestOptions, Response, ResponseContentType} from '@angular/http';
import {Observable} from 'rxjs/Rx';
import {AuthHttp} from "angular2-jwt";
import {Employee} from "../../../dto/employee.model";
import {EmployeeCount} from "../../../dto/employee.count.model";


@Injectable()
export class EmployeeService {

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

  getMyInfo(): Observable<Employee> {
    let url = `/api/hisemployee/employees/getMyInfo`;
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
