import {ProcurementGoods} from "./procurement-goods.model";

export class ProcurementRequest {

  public id: number;
  public requester: string;
  public goods: ProcurementGoods[];
  public vendorName: string;
  public contact: string;
  public contactTelephone: string;
  submittedData: Date;

  //ProcurementEntity procurement:Procurement;

  constructor() {
  }


}
