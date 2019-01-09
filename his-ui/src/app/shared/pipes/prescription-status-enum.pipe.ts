import {Pipe, PipeTransform} from '@angular/core';
import {PrescriptionStatusEnum} from "../../core/enums/prescription-status.enum";

@Pipe({
  name: 'prescriptionStatusEnum'
})
export class PrescriptionStatusEnumPipe implements PipeTransform {

  transform(value: any, args?: any): any {

    switch (value) {
      case PrescriptionStatusEnum.UNSUBMITTED:
        return "未提交";
      case PrescriptionStatusEnum.UNPAID:
        return "未付款";
      case PrescriptionStatusEnum.PAID:
        return "已付款";
      case PrescriptionStatusEnum.DISPENSED:
        return "已发药";
      case PrescriptionStatusEnum.UNDISPENSED:
        return "未发药";
    }
  }
}
