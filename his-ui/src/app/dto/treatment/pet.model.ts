import {PetOwner} from "./pet-owner.model";
import {PetColorEnum} from "../../enums/pet.color.enum";
import {PetGenderEnum} from "../../enums/pet.gender.enum";
import {PetType} from "./pet.type.model";

export class Pet {
  constructor(public petOwner?: PetOwner,
              public sterilized?: Boolean,
              public color?: PetColorEnum,
              public dateOfBirth?: Date,
              public age?: number,
              public gender?: PetGenderEnum,
              public name?: string,
              public id?:number,
              public petType?: PetType) {
  }
}


