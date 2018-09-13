import {Injectable} from '@angular/core';
import {AbstractService} from "../abstract.service";
import {AuthHttp} from "angular2-jwt";
import {Observable} from "rxjs/Observable";
import {CrudService} from "../crud.service";
import {TreatmentCase} from "../../dto/treatment/treatment-case.model";
import {ServiceConstants} from "../../components/common/service-constants";

@Injectable()
export class TreatmentCaseService extends CrudService<TreatmentCase> {


  rootUrl: string = `${ServiceConstants.TREATMENT_URL}/treatment-cases`;

  constructor(authHttp: AuthHttp) {

    super(`${ServiceConstants.TREATMENT_URL}/treatment-cases`,authHttp);

  }

  findAllByPetId(pid: number): Observable<any[]> {
    return this.authHttp.get(`${this.rootUrl}/find-all-by-pet/${pid}`).map(this.extractData);
  }

  getPrescriptions(tid:number):Observable<any[]>{
    return this.authHttp.get(`${this.rootUrl}/${tid}/prescriptions`).map(this.extractData);
  }

  addMedicalTestReport(tid: number, medicalReportTemplateId: number):Observable<any> {
    return this.authHttp.put(`${this.rootUrl}/${tid}/add-medical-test/${medicalReportTemplateId}`,{}).map(this.extractData);
  }

  generateMedicalTestOrder(uuid: string): Observable<boolean> {
    return this.authHttp.post(`${this.rootUrl}/${uuid}/generate-medical-test-order`, '').map(this.extractData);
  }

  setPrescriptions(tid:number,value: any) {
    return this.authHttp.post(`${this.rootUrl}/${tid}/prescriptions`, value).map(this.extractData);
  }
}
