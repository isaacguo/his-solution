import {Injectable} from '@angular/core';
import {AuthHttp} from "angular2-jwt";
import {FormGroup} from "@angular/forms";
import {Observable} from "rxjs/Observable";
import {AbstractService} from "../abstract.service";
import {MedicalTestReportItem} from "../../dto/medical-test/medical-test-report-item.model";
import {MedicalTestReport} from "../../dto/medical-test/medical-test-report.model";

@Injectable()
export class MedicalTestReportService extends AbstractService {


  rootUrl: string = "/api/hismedicaltest/reports";
  createReportUrl: string = `${this.rootUrl}/create`;

  //private procurementStatusRootUrl: string = `${this.rootUrl}/`;

  constructor(private authHttp: AuthHttp) {
    super();
  }

  createReport(request: FormGroup): Observable<MedicalTestReport> {
    return this.authHttp.post(this.createReportUrl, request).map(this.extractData);
  }

  findAll(): Observable<MedicalTestReport[]> {
    return this.authHttp.get(this.rootUrl).map(this.extractData);
  }

  findById(updateId: number):Observable<any> {
   return this.authHttp.get(`${this.rootUrl}/${updateId}`).map(this.extractData);
  }

  deleteById(updateId: number) {
   return this.authHttp.delete(`${this.rootUrl}/${updateId}`).map(r => {
     return this.extractTextData(r) === "true" ? true : false;
   });
  }


}
