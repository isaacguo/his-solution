import {Pipe, PipeTransform} from '@angular/core';
import {GenderEnum} from "../../core/enums/gender.enum";

@Pipe({
  name: 'genderEnum'
})
export class GenderEnumPipe implements PipeTransform {

  transform(value: any, args?: any): any {
    return GenderEnum[value];
  }

}
