import {Price} from "./price.model";

export interface ChargeItemRequest {
  id: number;
  uuid: string;
  amount: number;
  price: Price;
  discount: number;

}
