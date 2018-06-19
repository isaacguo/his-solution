import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-medical-test-settings-department-report-templates',
  templateUrl: './medical-test-settings-department-report-templates.component.html',
  styleUrls: ['./medical-test-settings-department-report-templates.component.css']
})
export class MedicalTestSettingsDepartmentReportTemplatesComponent implements OnInit {

  @Input()
  departmentId: number;

  constructor() { }

  ngOnInit() {
  }

}
