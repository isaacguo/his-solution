import {ChangeDetectionStrategy, Component, OnInit} from '@angular/core';
import {AbstractItemSelectableTableComponent} from "../../../shared/components/abstract-item-selectable-table/abstract-item-selectable-table.component";
import {EmployeeListItem} from "../../../core/models/employee/employee-list-item.model";

@Component({
  selector: 'app-treatment-settings-room-employee-open-switch',
  templateUrl: './treatment-settings-room-employee-open-switch.component.html',
  styleUrls: ['./treatment-settings-room-employee-open-switch.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class TreatmentSettingsRoomEmployeeOpenSwitchComponent extends AbstractItemSelectableTableComponent<EmployeeListItem> implements OnInit {


  constructor() {
    super();
  }

  ngOnInit() {
  }

}
