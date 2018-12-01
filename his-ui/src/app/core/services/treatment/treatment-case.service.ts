import {Injectable} from '@angular/core';
import {AuthHttp} from "angular2-jwt";
import {Observable} from "rxjs/Observable";
import {CrudService} from "../crud.service";
import {TreatmentCase} from "../../../treatment/models/treatment-case.model";
import {PetOwner} from "../../../treatment/models/pet-owner.model";
import {ServiceConstants} from "../../../shared/service-constants";

@Injectable()
export class TreatmentCaseService extends CrudService<TreatmentCase> {



  rootUrl: string = `${ServiceConstants.TREATMENT_URL}/treatment-cases`;

  constructor(authHttp: AuthHttp) {

    super(`${ServiceConstants.TREATMENT_URL}/treatment-cases`,authHttp);

  }


  closeTreatmentCase(tId:number):Observable<TreatmentCase>
  {
    return this.authHttp.put(`${this.rootUrl}/${tId}/close`,{}).map(this.extractData);
  }


  getPetOwnerInfoByTreatmentCaseId(tId:number): Observable<PetOwner>
  {
    return this.authHttp.get(`${this.rootUrl}/get-pet-owner-info-by-treatment-case-id/${tId}`).map(this.extractData);
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
