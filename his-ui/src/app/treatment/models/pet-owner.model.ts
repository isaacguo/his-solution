import {GenderEnum} from "../../core/enums/gender.enum";
import {Pet} from "./pet.model";

export interface PetOwner {
  name?: string,
  gender?: GenderEnum,
  dateOfBirth?: Date,
  address?: string,
  cellPhone?: string,
  email?: string,
  homePhone?: string,
  id?: number,
  petList?: Pet[],
  memberNumber?: string,
  uuid?:string

}
