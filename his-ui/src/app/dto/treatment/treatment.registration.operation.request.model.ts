import {RegistrationStatusEnum} from "../../enums/registration-status.enum";

export class TreatmentRegistrationOperationRequestModel {
  constructor(public  doctorId?: number,
              public  operatorId?: number,
              public  petId?: number,
              public  bookDate?: Date,
              public registrationStatus?: string,
              public  indexOfDay?: number,
              public  id?: number) {

  }
}
