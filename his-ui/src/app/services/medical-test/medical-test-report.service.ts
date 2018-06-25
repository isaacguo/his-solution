import {Injectable} from '@angular/core';
import {Observable} from "rxjs/Observable";
import {FormGroup} from "@angular/forms";
import {MedicalTestReportTemplate} from "../../dto/medical-test/medical-test-report-template.model";
import {AuthHttp} from "angular2-jwt";
import {AbstractService} from "../abstract.service";
import {MedicalTestReport} from "../../dto/medical-test/medical-test-report.model";

@Injectable()
export class MedicalTestReportService extends AbstractService {

  rootUrl: string = "/api/hismedicaltest/reports";

  createReportUrl: string = `${this.rootUrl}`;
  updateReportUrl: string = `${this.rootUrl}`;
  updateReportStatusUrl: string = `${this.rootUrl}/update-status`;


  constructor(private authHttp: AuthHttp) {
    super();
  }

  createReport(request: any): Observable<boolean> {
    return this.authHttp.post(this.createReportUrl, request).map(r => {
      return this.extractTextData(r) === "true" ? true : false;
    });
  }

  updateReport(request: any): Observable<any> {
    return this.authHttp.put(this.updateReportUrl, request).map(r => {
      return this.extractTextData(r) === "true" ? true : false;
    });
  }

  findAll(): Observable<any[]> {
    return this.authHttp.get(this.rootUrl).map(this.extractData);
  }

  findById(updateId: any): Observable<any> {
    return this.authHttp.get(`${this.rootUrl}/${updateId}`).map(this.extractData);
  }

  findReportsByIds(reportIds: any[]): Observable<any> {
    return this.authHttp.post(`${this.rootUrl}/get-reports-by-ids`, {'reportIdLists': reportIds}).map(this.extractData);
  }
}
