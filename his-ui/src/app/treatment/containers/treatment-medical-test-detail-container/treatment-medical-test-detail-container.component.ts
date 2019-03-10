import { Component, OnInit } from '@angular/core';
import {Observable} from "rxjs";
import {MedicalTestReport} from "../../../medical-test/models/medical-test-report.model";
import {ActivatedRoute, Router} from "@angular/router";
import {MedicalTestReportService} from "../../../core/services/medical-test/medical-test-report.service";

@Component({
  selector: 'app-treatment-medical-test-detail-container',
  templateUrl: './treatment-medical-test-detail-container.component.html',
  styleUrls: ['./treatment-medical-test-detail-container.component.css']
})
export class TreatmentMedicalTestDetailContainerComponent implements OnInit {

  medicalTestReport$ = new Observable<MedicalTestReport>();

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private medicalTestReportService: MedicalTestReportService
  ) {
    this.medicalTestReport$ = this.route.params.mergeMap(p => {
      return this.medicalTestReportService.findByUuid(p['reportUuid']);
    })
  }

  ngOnInit() {
  }

}
