import {GenderEnum} from "../enums/gender.enum";
import {Pet} from "./pet.model";

export class PetOwner {
  constructor(public name?: string,
              public gender?: GenderEnum,
              public dateOfBirth?: Date,
              public address?: string,
              public cellPhone?: string,
              public email?: string,
              public homePhone?: string,
              public id?:number,
              public petList?:Pet[],
              public memberNumber?:string
              ) {

  }
}
