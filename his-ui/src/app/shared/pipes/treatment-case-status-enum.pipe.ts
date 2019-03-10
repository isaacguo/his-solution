import {Pipe, PipeTransform} from '@angular/core';
import {TreatmentCaseStatusEnum} from "../../core/enums/treatment-case-status.enum";

@Pipe({
  name: 'treatmentCaseStatusEnum'
})
export class TreatmentCaseStatusEnumPipe implements PipeTransform {

  transform(value: any, args?: any): any {
    switch (value) {
      case TreatmentCaseStatusEnum.BOOKED:
        return "已预约";
      case TreatmentCaseStatusEnum.UNPAID:
        return "未付款";
      case TreatmentCaseStatusEnum.UNPRESENTED:
        return "未候诊";
      case TreatmentCaseStatusEnum.WAITING:
        return "等候中";
      case TreatmentCaseStatusEnum.CURING:
        return "就诊中";
      case TreatmentCaseStatusEnum.CALLED:
        return "已过号";
      case TreatmentCaseStatusEnum.FINISHED:
        return "已完成";
      case TreatmentCaseStatusEnum.UNFINISHED:
        return "未完成"
    }


    return TreatmentCaseStatusEnum[value];
  }

}
