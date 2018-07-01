import {Injectable} from '@angular/core';
import {AbstractService} from "../abstract.service";
import {AuthHttp} from "angular2-jwt";
import {Observable} from "rxjs/Rx";
import {TreatmentRegistrationModel} from "../../dto/treatment/treatment.registration.model";
import {Http, Headers, RequestOptions, Response, ResponseContentType} from '@angular/http';
import {TreatmentRegistrationOperationRequestModel} from "../../dto/treatment/treatment.registration.operation.request.model";
import {RegistrationStatusEnum} from "../../enums/registration-status.enum";

@Injectable()
export class RegistrationService extends AbstractService {

  rootUrl: string = "/api/histreatment/registrations";

  constructor(private authHttp: AuthHttp) {
    super();
  }

  createRegistration(doctorId: number, operatorId: number, petId: number, bookDate?: Date, status?: string): Observable<TreatmentRegistrationModel> {
    let url = `${this.rootUrl}/create-registration`;
    let operationRequest = new TreatmentRegistrationOperationRequestModel(doctorId, operatorId, petId, null, status);
    return this.authHttp.post(url, operationRequest).map(this.extractData);
  }

  findMyRegistrationToday(): Observable<any[]> {
    let url = `${this.rootUrl}/find-my-registration-today`;
    return this.authHttp.get(url).map(this.extractData);
  }


  updateStatus(regId: number, registrationStatusEnum:string): Observable<boolean> {

    let url = `${this.rootUrl}/updateStatus`;
    return this.authHttp.put(url,{'id':regId, 'registrationStatus':registrationStatusEnum}).map(this.extractData);

  }


}
