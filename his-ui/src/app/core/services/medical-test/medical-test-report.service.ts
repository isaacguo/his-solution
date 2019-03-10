import {Injectable} from '@angular/core';
import {Observable} from "rxjs/Observable";
import {FormGroup} from "@angular/forms";
import {AuthHttp} from "angular2-jwt";
import {AbstractService} from "../abstract.service";
import {ServiceConstants} from "../../../shared/service-constants";
import {RegistrationStatusEnum} from "../../enums/registration-status.enum";

@Injectable()
export class MedicalTestReportService extends AbstractService {


  rootUrl: string = `${ServiceConstants.MEDICALTEST_URL}/reports`;

  createReportUrl: string = `${this.rootUrl}`;
  updateReportUrl: string = `${this.rootUrl}`;
  updateReportStatusUrl: string = `${this.rootUrl}/update-status`;


  constructor(private authHttp: AuthHttp) {
    super();
  }

  createReports(request: any): Observable<any> {
    return this.authHttp.post(this.createReportUrl, request).map(this.extractData);
  }


  updateReport(request: any): Observable<any> {
    return this.authHttp.put(this.updateReportUrl, request).map(r => {
      return this.extractTextData(r) === "true" ? true : false;
    });
  }

  findAll(): Observable<any[]> {
    return this.authHttp.get(this.rootUrl).map(this.extractData);
  }

  findAllOnPage(page:number, size:number=15):Observable<any>
  {
    let params: any = {'page': page.toString(), 'size': size.toString()};
    return this.authHttp.get(`${this.rootUrl}/all-on-page`, {params: params}).map(this.extractData);
  }

  findByUuid(uuid: string): Observable<any> {
    return this.authHttp.get(`${this.rootUrl}/find-by-uuid/${uuid}`).map(this.extractData);
  }

  findById(updateId: any): Observable<any> {
    return this.authHttp.get(`${this.rootUrl}/${updateId}`).map(this.extractData);
  }

  findReportsByUuids(reportUuidList: any[]): Observable<any> {
    return this.authHttp.post(`${this.rootUrl}/get-reports-by-uuids`, {'reportUuidLists': reportUuidList}).map(this.extractData);
  }

  removeReport(uuid: string) {
    return this.authHttp.delete(`${this.rootUrl}/${uuid}/`).map(this.extractData);
  }

  findByPetUuidHistory(uuid: any):Observable<any[]> {
    return this.authHttp.get(`${this.rootUrl}/findByPetUuidHistory/${uuid}/`).map(this.extractData);
  }

  findByPetUuidToday(uuid: any):Observable<any[]> {
    return this.authHttp.get(`${this.rootUrl}/findByPetUuidToday/${uuid}/`).map(this.extractData);
  }
}
