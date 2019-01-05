import {Component, OnInit} from '@angular/core';
import {Observable} from "rxjs";
import {MedicalTestReport} from "../../models/medical-test-report.model";
import {ActivatedRoute, Router} from "@angular/router";
import {MedicalTestReportService} from "../../../core/services/medical-test/medical-test-report.service";

@Component({
  selector: 'app-medical-test-report-update-container',
  templateUrl: './medical-test-report-update-container.component.html',
  styleUrls: ['./medical-test-report-update-container.component.css']
})
export class MedicalTestReportUpdateContainerComponent implements OnInit {

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

  onUpdateTestReport($event: any) {
    this.medicalTestReportService.updateReport($event).subscribe(r => {
      this.router.navigate(['query'],{relativeTo:this.route.parent});
    });
  }
}
