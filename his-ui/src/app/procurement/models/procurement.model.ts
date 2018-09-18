import {ProcurementRequest} from "./procurement-request.model";
import {ProcurementApproval} from "./procurement-approval.model";
import {ProcurementPurchase} from "./procurement-purchase.model";

export class Procurement {
  public orderNumber?: string; //单号
  public status?: string;
  public procurementRequest?: ProcurementRequest;
  public id?: number;
  public approvalList?: ProcurementApproval[];
  public procurementPurchase?: ProcurementPurchase;

  constructor() {
  }
}
