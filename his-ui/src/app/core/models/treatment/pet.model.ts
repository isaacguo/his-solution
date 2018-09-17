import {PetOwner} from "./pet-owner.model";
import {PetColorEnum} from "../../enums/pet.color.enum";
import {PetGenderEnum} from "../../enums/pet.gender.enum";
import {PetType} from "./pet.type.model";

export interface Pet {
  petOwner?: PetOwner,
  sterilized?: Boolean,
  color?: PetColorEnum,
  dateOfBirth?: Date,
  age?: number,
  gender?: PetGenderEnum,
  name?: string,
  id?: number,
  petType?: PetType
}


