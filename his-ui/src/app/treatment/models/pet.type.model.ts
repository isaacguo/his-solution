import {Pet} from "./pet.model";

export interface PetType {

  isRoot?: Boolean,
  name?: String,
  children?: PetType[],
  parent?: PetType,
  id?: number,
  pets?: Pet[]

}
