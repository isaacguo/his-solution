import {Injectable} from "@angular/core";
import {Headers, RequestOptions, Response} from '@angular/http';
import {Observable} from 'rxjs/Rx';
import {AuthHttp} from "angular2-jwt";
import {Department} from "../../dto/department.model";

@Injectable()
export class DepartmentService {


  rootUrl: string = "/api/histreatment/departments";

  constructor(private authHttp: AuthHttp) {
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

  getDepartmentByUuid(uuid: string): Observable<Department> {
    let url = `${this.rootUrl}/getDepartmentByUuid/${uuid}/`;
    return this.authHttp.get(url)
      .map(this.extractData);

  }


  private getOptions() {
    let headers = new Headers({'Content-Type': 'application/json'}); // ... Set content type to JSON
    let options = new RequestOptions({headers: headers});
    return options;
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
