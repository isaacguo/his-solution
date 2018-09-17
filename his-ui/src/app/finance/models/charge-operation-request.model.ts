import {ChargeItemRequest} from "./charge-item-request.model";

export interface ChargeOperationRequest {

  ownerUuid: string;
  petUuid: string;
  items: ChargeItemRequest[];
  treatmentCaseUuid: string;

}
