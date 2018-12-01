import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {DepartmentOperationRequest} from "../../../treatment/models/department.operation.request.model";
import {Department} from "../../../treatment/models/department.model";

@Component({
  selector: 'app-medical-test-settings-room-detail',
  templateUrl: './medical-test-settings-room-detail.component.html',
  styleUrls: ['./medical-test-settings-room-detail.component.css']
})
export class MedicalTestSettingsRoomDetailComponent implements OnInit {

  @Input()
  department: any
  @Output()
  openCheck = new EventEmitter<DepartmentOperationRequest>();

  constructor() { }

  ngOnInit() {
  }

  onOutCheck($event)
  {
    this.openCheck.emit($event);
  }

}
