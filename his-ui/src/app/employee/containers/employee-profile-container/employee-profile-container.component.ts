import {ChangeDetectionStrategy, Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-employee-profile-container',
  templateUrl: './employee-profile-container.component.html',
  styleUrls: ['./employee-profile-container.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class EmployeeProfileContainerComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
