import {Injectable} from '@angular/core';
import {AuthHttp} from "angular2-jwt";
import {FormGroup} from "@angular/forms";
import {Observable} from "rxjs/Observable";
import {AbstractService} from "../abstract.service";
import {MedicalTestReportTemplate} from "../../dto/medical-test/medical-test-report-template.model";

@Injectable()
export class MedicalTestReportTemplateService extends AbstractService {


  rootUrl: string = "/api/hismedicaltest/report-templates";
  createReportUrl: string = `${this.rootUrl}/create`;
  updateReportUrl: string = `${this.rootUrl}/update`;

  //private procurementStatusRootUrl: string = `${this.rootUrl}/`;

  constructor(private authHttp: AuthHttp) {
    super();
  }

  createReport(request: FormGroup): Observable<MedicalTestReportTemplate> {
    return this.authHttp.post(this.createReportUrl, request).map(this.extractData);
  }


  updateReport(request: any):Observable<any>{
    return this.authHttp.post(this.updateReportUrl, request).map(this.extractData);

  }

  findAll(): Observable<MedicalTestReportTemplate[]> {
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
