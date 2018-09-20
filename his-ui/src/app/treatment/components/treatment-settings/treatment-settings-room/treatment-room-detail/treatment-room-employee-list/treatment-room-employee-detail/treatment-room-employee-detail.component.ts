import {Component, Input, OnChanges, SimpleChanges} from '@angular/core';
import {Employee} from "../../../../../../../employee/models/employee.model";
import {TreatmentEmployeeModel} from "../../../../../../models/treatment.employee.model";
import {TreatmentEmployeeService} from "../../../../../../../core/services/treatment/treatment-employee.service";

@Component({
  selector: 'app-treatment-room-employee-detail',
  templateUrl: './treatment-room-employee-detail.component.html',
  styleUrls: ['./treatment-room-employee-detail.component.css']
})
export class TreatmentRoomEmployeeDetailComponent implements OnChanges {

  @Input()
  employee: Employee;
  @Input()
  depId: number;

  treatmentEmployeeModel: TreatmentEmployeeModel;

  constructor(private treatmentEmployeeService: TreatmentEmployeeService) {
  }

  onSwitchChange(event: boolean) {

    let t: TreatmentEmployeeModel = {
      canBeRegistered: event,
      loginAccount: this.employee.loginAccount,
      name: this.employee.fullName,
      empId: this.employee.id,
      uuid: this.employee.uuid,
      departmentId: this.depId
    }

    this.treatmentEmployeeService.setCanBeRegisteredValue(t).subscribe(r => {
      this.loadData();
    });
  }

  ngOnChanges(changes: SimpleChanges): void {
    this.loadData();
  }

  loadData() {
    if (this.employee != undefined)
      this.treatmentEmployeeService.findByEmpId(this.employee.id).subscribe(r => {
        this.treatmentEmployeeModel = r
      });
  }


}
