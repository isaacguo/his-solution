import { Injectable } from '@angular/core';
import {CrudService} from "../crud.service";
import {AuthHttp} from "angular2-jwt";

@Injectable()
export class PharmacyMedicineService extends CrudService  {

  rootUrl: string = "/api/hismedicine/pharmacy-medicine";

  constructor(authHttp: AuthHttp) {
    super("/api/hismedicine/pharmacy-medicine", authHttp);
  }

}
