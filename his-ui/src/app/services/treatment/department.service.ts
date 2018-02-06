import {Injectable} from "@angular/core";
import {Http, Headers, RequestOptions, Response, ResponseContentType} from '@angular/http';
import {Observable} from 'rxjs/Rx';
import {AuthHttp} from "angular2-jwt";
import {Department} from "../../dto/department.model";
import {Doctor} from "../../dto/doctor.model";

@Injectable()
export class DepartmentService {

  constructor(private authHttp: AuthHttp) {
  }

  getDepartments(): Observable<Department[]> {

    let url = `/api/histreatment/departments`;
    return this.authHttp.get(url)
      .map(this.extractData);
  }

  getDoctorsInDepartmentByUuid(uuid: string): Observable<Doctor[]> {
    let url = `/api/histreatment/departments/getDoctorsInDepartmentByUuid/${uuid}/`;
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
