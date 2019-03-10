import {TreatmentEmployeeModel} from "./treatment.employee.model";
import {Pet} from "./pet.model";

export interface TreatmentRegistrationModel {
  price?: number,
  indexOfDay?: number,
  rid?: number;
  createdDate?: Date,
  bookDate?: Date,
  doctor?: TreatmentEmployeeModel,
  operator?: TreatmentEmployeeModel,
  pet?: Pet
}
