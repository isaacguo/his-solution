import {Price} from "./price.model";

export class ChargeItemRequest {
  public id: number;
  public uuid: string;
  public amount: number;
  public price: Price;
  public discount: number;

  constructor() {
  }


}
