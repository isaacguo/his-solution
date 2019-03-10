import {
  ChangeDetectionStrategy,
  Component,
  EventEmitter,
  Input,
  OnChanges,
  OnInit,
  Output,
  SimpleChanges
} from '@angular/core';
import {Department} from "../../models/department.model";
import {DepartmentOperationRequest} from "../../models/department.operation.request.model";

@Component({
  selector: 'app-treatment-settings-room-open-switch',
  templateUrl: './treatment-settings-room-open-switch.component.html',
  styleUrls: ['./treatment-settings-room-open-switch.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class TreatmentSettingsRoomOpenSwitchComponent implements OnInit {

  @Input()
  department: Department
  @Output()
  openCheck = new EventEmitter<DepartmentOperationRequest>();

  constructor() {
  }

  ngOnInit() {
  }

  onOpenToFrontDesk(event: boolean) {
  }

  onOutCheck(event: boolean) {
    this.openCheck.emit({
      openToFrontDesk: event,
      name: this.department.name,
      depId: this.department.depId
    });

  }
}
