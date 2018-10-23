import {Pipe, PipeTransform} from '@angular/core';
import {RegistrationStatusEnum} from "../../core/enums/registration-status.enum";

@Pipe({
  name: 'registrationStatusEnum'
})
export class RegistrationStatusEnumPipe implements PipeTransform {

  transform(value: any, args?: any): any {
    return RegistrationStatusEnum[value];
  }

}
