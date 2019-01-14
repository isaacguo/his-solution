import {ProcurementPurchaseGood} from "./procurement-purchase-good.model";

export class ProcurementPurchase {

  public generatedDateTime?: Date; //表单生成时间
  public goods?: ProcurementPurchaseGood[];
  public id?: number;
  public totalPrice?: number;

  public assignTo:string;

  constructor() {
  }
}
