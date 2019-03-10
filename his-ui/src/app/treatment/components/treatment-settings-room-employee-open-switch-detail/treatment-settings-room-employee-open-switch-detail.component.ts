import {ChangeDetectionStrategy, Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {TreatmentEmployeeModel} from "../../models/treatment.employee.model";
import {EmployeeListItem} from "../../../core/models/employee/employee-list-item.model";

@Component({
  selector: 'app-treatment-settings-room-employee-open-switch-detail',
  templateUrl: './treatment-settings-room-employee-open-switch-detail.component.html',
  styleUrls: ['./treatment-settings-room-employee-open-switch-detail.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class TreatmentSettingsRoomEmployeeOpenSwitchDetailComponent implements OnInit {

  @Input()
  employeeInfoInTreatment: TreatmentEmployeeModel;
  @Input()
  employeeInfoInEmployee:EmployeeListItem;
  @Output()
  employeeOpenChecked = new EventEmitter<boolean>()

  constructor() {
  }

  ngOnInit() {
  }
  onOutCheck(event)
  {
    this.employeeOpenChecked.emit(event);
  }

}
