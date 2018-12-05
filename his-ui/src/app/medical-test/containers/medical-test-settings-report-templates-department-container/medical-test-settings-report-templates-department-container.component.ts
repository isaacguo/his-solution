import {ChangeDetectionStrategy, Component, OnInit} from '@angular/core';
import {MedicalTestReportTemplateService} from "../../../core/services/medical-test/medical-test-report-template.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Observable} from "rxjs/Observable";

@Component({
  selector: 'app-medical-test-settings-report-templates-department-container',
  templateUrl: './medical-test-settings-report-templates-department-container.component.html',
  styleUrls: ['./medical-test-settings-report-templates-department-container.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class MedicalTestSettingsReportTemplatesDepartmentContainerComponent {

  reportTemplates$: Observable<any>;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private medicalTestReportTemplateService: MedicalTestReportTemplateService
  ) {

    this.reportTemplates$ = this.route.params.mergeMap((p) => {
      return this.medicalTestReportTemplateService.findReportTemplatesByDepartmentId(p['departmentId']);
    })

  }

}
