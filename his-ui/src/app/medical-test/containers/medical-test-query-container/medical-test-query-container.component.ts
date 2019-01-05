import {Component, OnInit} from '@angular/core';
import {MedicalTestReportTemplateService} from "../../../core/services/medical-test/medical-test-report-template.service";
import {MedicalTestReportService} from "../../../core/services/medical-test/medical-test-report.service";
import {PetService} from "../../../core/services/treatment/pet.service";
import {TreatmentCaseService} from "../../../core/services/treatment/treatment-case.service";
import {ActivatedRoute, Router} from "@angular/router";
import {BehaviorSubject, Observable} from "rxjs";
import {PageableParams} from "../../../core/models/pageable-params.model";
import {MedicalTestReport} from "../../models/medical-test-report.model";

@Component({
  selector: 'app-medical-test-query-container',
  templateUrl: './medical-test-query-container.component.html',
  styleUrls: ['./medical-test-query-container.component.css']
})
export class MedicalTestQueryContainerComponent implements OnInit {

  pageInfoSubject = new BehaviorSubject<PageableParams>({size: 15, status: "WAITING", page: 0});
  pageInfo$ = this.pageInfoSubject.asObservable();
  pageData$: Observable<any>;
  selectedStatus$:Observable<string>;


  constructor(private router: Router,
              private route: ActivatedRoute,
              private treatmentCaseService: TreatmentCaseService,
              private petService: PetService,
              private medicalTestReportService: MedicalTestReportService,
              private medicalTestReportTemplateService: MedicalTestReportTemplateService) {

    this.pageData$ = this.pageInfo$.mergeMap(page => this.medicalTestReportService.findAllOnPage(page.page, page.size))
  }

  onPageChanged(event) {
    this.pageInfoSubject.next(event);
  }

  ngOnInit() {
  }

  onModifyMedicalTestReport($event: MedicalTestReport) {
    this.router.navigate(['reports',$event.uuid ],{relativeTo:this.route.parent})
  }
}
