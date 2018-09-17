import {Injectable} from '@angular/core';
import {Observable} from "rxjs/Observable";
import {AuthHttp} from "angular2-jwt";
import {AbstractService} from "../../core/services/abstract.service";
import {Procurement} from "../models/procurement.model";
import {ProcurementOperationRequest} from "../models/procurement-operation-request.model";

@Injectable()
export class ProcurementService extends AbstractService {

  rootUrl: string = "/api/hisprocurement/procurements";
  private myProcurementsUrl: string = `${this.rootUrl}/user`;
  private findProcurementsByQueryUrl: string = `${this.rootUrl}/user/query`;
  private myProcurementsByAssignedPurchaseUrl: string = `${this.rootUrl}/user/purchases`;
  private updateStatusUrl: string = `${this.rootUrl}/updateStatus`;


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

  findByQuery(request: ProcurementOperationRequest): Observable<Procurement[]> {
    return this.authHttp.post(this.findProcurementsByQueryUrl, request).map(this.extractData);
  }

  updateStatus(request: ProcurementOperationRequest): Observable<boolean> {
    return this.authHttp.post(this.updateStatusUrl, request).map(r => {
      return this.extractTextData(r) === "true" ? true : false;
    });

  }

}
