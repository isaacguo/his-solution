import { Pipe, PipeTransform } from '@angular/core';
import {PrescriptionStatusEnum} from "../../core/enums/prescription-status.enum";

@Pipe({
  name: 'prescriptionStatusEnum'
})
export class PrescriptionStatusEnumPipe implements PipeTransform {

  transform(value: any, args?: any): any {
    return PrescriptionStatusEnum[value];
  }

}
