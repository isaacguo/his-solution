import {Pet} from "./pet.model";

export class PetType {

  constructor(public isRoot?: Boolean,
              public name?: String,
              public children?: PetType[],
              public parent?: PetType,
              public id?: number,
              public pets?: Pet[]) {
  }

}
