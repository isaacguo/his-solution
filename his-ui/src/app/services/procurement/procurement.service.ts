import {Injectable} from '@angular/core';
import {Observable} from "rxjs/Observable";
import {AuthHttp} from "angular2-jwt";
import {ProcurementStatus} from "../../dto/procurement/procurement-status.model";
import {AbstractService} from "../abstract.service";
import {Procurement} from "../../dto/procurement/procurement.model";

@Injectable()
export class ProcurementService extends AbstractService {

  rootUrl: string = "/api/hisprocurement/procurements";
  private myProcurementsUrl: string = `${this.rootUrl}/user`;
  private myProcurementsByAssignedPurchaseUrl: string = `${this.rootUrl}/user/purchases`;


  constructor(private authHttp: AuthHttp) {
    super();
  }

  getMyProcurements(): Observable<Procurement[]> {
    return this.authHttp.get(this.myProcurementsUrl).map(this.extractData);
  }

  getMyProcurementsByAssignedPurchaseUrl(): Observable<Procurement[]> {
    return this.authHttp.get(this.myProcurementsByAssignedPurchaseUrl).map(this.extractData);
  }

  findOneById(id: number) {
    return this.authHttp.get(`${this.rootUrl}/${id}`).map(this.extractData);
  }
}
