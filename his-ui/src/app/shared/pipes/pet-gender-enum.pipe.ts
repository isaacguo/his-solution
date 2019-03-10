import {Pipe, PipeTransform} from '@angular/core';
import {PetGenderEnum} from "../../core/enums/pet.gender.enum";

@Pipe({
  name: 'petGenderEnum'
})
export class PetGenderEnumPipe implements PipeTransform {

  transform(value: any, args?: any): any {
    return PetGenderEnum[value];
  }

}
