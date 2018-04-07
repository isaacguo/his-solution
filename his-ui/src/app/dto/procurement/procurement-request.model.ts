import {ProcurementGoods} from "./procurement-goods.model";
import {ProcurementRequestVendorInfo} from "./procurement-request-vendor-info.model";

export class ProcurementRequest {

  public id: number;
  public requester: string;
  public goods: ProcurementGoods[];
  public vendorInfo: ProcurementRequestVendorInfo;
  public explanation: string;
  public submittedData: Date;
  public totalPrice: number;

  constructor() {
  }

}
