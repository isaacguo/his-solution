import {Vendor} from "./vendor.model";
import {ProcurementStatus} from "./procurement-status.model";
import {ProcurementRequest} from "./procurement-request.model";

export class Procurement {
  public orderNumber: string; //单号
  public vendor: string;
  public contact: string;
  public contactTelephone:string;
  public status: string;
  public procurementRequest: ProcurementRequest;
  public id: number;

  constructor() {
  }
}
