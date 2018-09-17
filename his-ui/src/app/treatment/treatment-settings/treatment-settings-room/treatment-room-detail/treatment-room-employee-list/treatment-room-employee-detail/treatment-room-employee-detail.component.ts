import {Component, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {Employee} from "../../../../../../../dto/employee/employee.model";
import {TreatmentEmployeeService} from "../../../../../../../services/treatment/treatment-employee.service";
import {TreatmentEmployeeModel} from "../../../../../../../dto/treatment/treatment.employee.model";
import {Department} from "../../../../../../../dto/treatment/department.model";

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
    let t: TreatmentEmployeeModel = new TreatmentEmployeeModel();

    t.canBeRegistered = event;
    t.loginAccount = this.employee.loginAccount;
    t.name = this.employee.fullName;
    t.empId = this.employee.id;
    t.uuid = this.employee.uuid;
    t.loginAccount = this.employee.loginAccount;
    t.departmentId = this.depId;

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
