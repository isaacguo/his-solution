import {TreatmentEmployeeModel} from "./treatment.employee.model";
import {Pet} from "./pet.model";

export class TreatmentRegistrationModel {
  constructor(public price?: number,
              public  indexOfDay?: number,
              public  id?: number,
              public  createdDate?: Date,
              public  bookDate?: Date,
              public  doctor?: TreatmentEmployeeModel,
              public  operator?: TreatmentEmployeeModel,
              public  pet?: Pet) {
  }
}
