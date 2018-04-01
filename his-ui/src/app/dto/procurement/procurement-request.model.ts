import {ProcurementGoods} from "./procurement-goods.model";

export class ProcurementRequest {

  public id: number;
  public requester: string;
  public goods: ProcurementGoods[];
  submittedData: Date;
  constructor() {
  }

}
