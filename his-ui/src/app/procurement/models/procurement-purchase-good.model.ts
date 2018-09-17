import {ProcurementGoods} from "./procurement-goods.model";

export class ProcurementPurchaseGood {

  public procurementRequestGoodEntity?: ProcurementGoods
  public vendor?: string;
  public contact?: string;
  public contactTelephone?: string;
  number?: number; //个数
  public packageSpecification?: string; //包装规格
  public packageUnit?: string; //包装单位
  public otherRequirements?: string;
  pricePerUnit?: number; //单价
  totalPrice?: number; //总价
  id?: number;

  constructor(){}
}
