import {ChargeItemRequest} from "./charge-item-request.model";

export class ChargeOperationRequest {

  public ownerUuid: string;
  public petUuid: string;
  public items: ChargeItemRequest[];
  public treatmentCaseUuid: string;

}
