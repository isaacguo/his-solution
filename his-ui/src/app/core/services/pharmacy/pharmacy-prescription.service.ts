import {Injectable} from '@angular/core';
import {ServiceConstants} from "../../../shared/service-constants";
import {AuthHttp} from "angular2-jwt";
import {CrudService} from "../crud.service";
import {Observable} from "rxjs";

@Injectable()
export class PharmacyPrescriptionService extends CrudService<any> {

  rootUrl: string = `${ServiceConstants.MEDICINE_URL}/prescriptions`;

  constructor(authHttp: AuthHttp) {
    super(`${ServiceConstants.MEDICINE_URL}/prescriptions`, authHttp);
  }

  findByPetUuidHistory(uuid: any): Observable<any[]> {
    return this.authHttp.get(`${this.rootUrl}/findByPetUuidHistory/${uuid}`).map(this.extractData);
  }

  findByPetUuidToday(uuid: any): Observable<any[]> {
    return this.authHttp.get(`${this.rootUrl}/findByPetUuidToday/${uuid}`).map(this.extractData);
  }

  submitPrescription(dto: any) {
    return this.authHttp.put(`${this.rootUrl}/submitPrescription`, dto).map(this.extractData);
  }


  findAllPrescriptionsByStatusOnPage(page: number, status: string = "UNPAID", size: number = 15): Observable<any> {
    let params: any = {'page': page.toString(), 'size': size.toString()};
    return this.authHttp.get(`${this.rootUrl}/all/${status}`, {params: params}).map(this.extractData);
  }

  medicineDispensed(prescription: any) {
    return this.authHttp.put(`${this.rootUrl}/medicineDispensed`, prescription).map(this.extractData);
  }

  withdrawMedicine(prescription: any) {
    return this.authHttp.put(`${this.rootUrl}/withdrawMedicine`, prescription).map(this.extractData);
  }
}
