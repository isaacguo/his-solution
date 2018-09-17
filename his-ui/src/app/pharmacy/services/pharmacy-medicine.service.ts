import {Injectable} from '@angular/core';
import {CrudService} from "../../core/services/crud.service";
import {AuthHttp} from "angular2-jwt";
import {Observable} from "rxjs/Observable";
import {ServiceConstants} from "../../shared/service-constants";

@Injectable()
export class PharmacyMedicineService extends CrudService<any> {

  rootUrl: string = `${ServiceConstants.MEDICINE_URL}/pharmacy-medicine`;

  constructor(authHttp: AuthHttp) {
    super(`${ServiceConstants.MEDICINE_URL}/pharmacy-medicine`, authHttp);
  }

  findMedicineByNameContains(name: any): Observable<any[]> {
    return this.authHttp.get(`${this.rootUrl}/findMedicineByNameContains/${name}`).map(this.extractData);
  }
}
