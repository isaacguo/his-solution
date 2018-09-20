import {Component, Input, OnInit} from '@angular/core';
import {MedicalTestReportTemplate} from "../../../../../models/medical-test-report-template.model";
import {MedicalTestDepartmentService} from "../../../../../../core/services/medical-test/medical-test-department.service";
import {MedicalTestReportTemplateService} from "../../../../../../core/services/medical-test/medical-test-report-template.service";

@Component({
  selector: 'app-medical-test-settings-department-report-templates',
  templateUrl: './medical-test-settings-department-report-templates.component.html',
  styleUrls: ['./medical-test-settings-department-report-templates.component.css']
})
export class MedicalTestSettingsDepartmentReportTemplatesComponent implements OnInit {

  @Input()
  departmentId: number;
  department: any = {};

  medicalTestReports: MedicalTestReportTemplate[] = [];

  reportEnabledMap: Map<number, boolean> = new Map<number, boolean>();

  constructor(private medicalTestDepartmentService: MedicalTestDepartmentService,
              private medicalTestReportService: MedicalTestReportTemplateService) {
  }

  ngOnInit() {
    this.loadData();
  }

  isReportEnabled(id: number): boolean {
    let index = (<any[]>this.department.supportedReportTemplates).findIndex(r => r.id === id);
    return index > -1;
  }

  loadData() {

    this.medicalTestDepartmentService.getDepartmentByDepId(this.departmentId).subscribe(r => {
      this.department = r;

    });

    this.medicalTestReportService.findAll().subscribe(r => {
      this.medicalTestReports = r;
    })
  }

  onCheckChanged(medicalTestReport, event) {
    if (event.target.checked)
      this.medicalTestDepartmentService.addSupportedTestReportTemplate(this.department.depId, medicalTestReport.id).subscribe(r => {
        this.loadData();
      })
    else
      this.medicalTestDepartmentService.removeSupportedTestReportTemplate(this.department.depId, medicalTestReport.id).subscribe(r => {
        this.loadData();
      })
  }
}
