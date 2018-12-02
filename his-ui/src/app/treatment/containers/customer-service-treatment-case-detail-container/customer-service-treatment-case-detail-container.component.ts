import {ChangeDetectionStrategy, Component, OnInit} from '@angular/core';
import {Observable} from "rxjs/Observable";
import {TreatmentCase} from "../../models/treatment-case.model";
import {TreatmentCaseService} from "../../../core/services/treatment/treatment-case.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-customer-service-treatment-case-detail-container',
  templateUrl: './customer-service-treatment-case-detail-container.component.html',
  styleUrls: ['./customer-service-treatment-case-detail-container.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class CustomerServiceTreatmentCaseDetailContainerComponent  {

  treatmentCase: Observable<TreatmentCase>;
  medicalTestReportList:Observable<any>;
  medicineInfoData:Observable<any>;

  constructor(private treatmentCaseService: TreatmentCaseService,
              //private medicalTestReportService:MedicalTestReportService,
              private route: ActivatedRoute) {
    this.treatmentCase = this.route.parent.params.mergeMap(r => this.treatmentCaseService.readOne(r['treatmentCaseId']));

    //this.medicalTestReportList=this.treatmentCase.mergeMap(tc=>this.medicalTestReportService.findReportsByUuids(tc.medicalTestReportUuidList));

    /*
    this.medicalTestReportService.findReportsByUuids(this.detailedTreatmentCase.medicalTestReportUuidList).subscribe(r => {

      this.medicalTestReportUnsubmittedList = r.filter(report => {
        return ReportStatusEnum[report.reportStatus] === ReportStatusEnum.UNSUBMITTED;
      })
      this.medicalTestReportList = r.filter(report => ReportStatusEnum[report.reportStatus] !== ReportStatusEnum.UNSUBMITTED)

    });
    */


  }

}
