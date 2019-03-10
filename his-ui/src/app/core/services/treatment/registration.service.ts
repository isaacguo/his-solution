import {Injectable} from '@angular/core';
import {AuthHttp} from "angular2-jwt";
import {Observable} from "rxjs/Rx";
import {TreatmentRegistrationModel} from "../../../treatment/models/treatment.registration.model";
import {TreatmentRegistrationOperationRequestModel} from "../../../treatment/models/treatment.registration.operation.request.model";
import {ServiceConstants} from "../../../shared/service-constants";
import {CrudService} from "../crud.service";

@Injectable()
export class RegistrationService extends CrudService<any> {


  rootUrl: string = `${ServiceConstants.TREATMENT_URL}/registrations`;

  constructor(authHttp: AuthHttp) {
    super(`${ServiceConstants.TREATMENT_URL}/registrations`,authHttp);
  }

  findAllRegistrationsByStatusOnPage(page: number, status: string = "WAITING", size: number = 15): Observable<any> {
    let params: any = {'page': page.toString(), 'size': size.toString()};
    return this.authHttp.get(`${this.rootUrl}/all/${status}`, {params: params}).map(this.extractData);
  }

  createRegistration(doctorId: number, operatorId: number, petId: number, bookDate?: Date, status?: string, priceUuid?: string): Observable<TreatmentRegistrationModel> {
    let url = `${this.rootUrl}/create-registration`;
    let operationRequest: TreatmentRegistrationOperationRequestModel =
      {
        doctorId: doctorId,
        operatorId: operatorId,
        petId: petId,
        bookDate: null,
        registrationStatus: status,
        priceUuid: priceUuid
      };
    return this.authHttp.post(url, operationRequest).map(this.extractData);
  }

  findMyRegistrationToday(): Observable<any[]> {
    let url = `${this.rootUrl}/find-my-registration-today`;
    return this.authHttp.get(url).map(this.extractData);
  }


  updateStatus(regId: number, registrationStatusEnum: string): Observable<boolean> {

    let url = `${this.rootUrl}/updateStatus`;
    return this.authHttp.put(url, {'id': regId, 'registrationStatus': registrationStatusEnum}).map(this.extractData);

  }


}
