import {ChangeDetectionStrategy, Component, Input, OnInit} from '@angular/core';
import {TreatmentCase} from "../../models/treatment-case.model";

@Component({
  selector: 'app-customer-service-treatment-case-detail',
  templateUrl: './customer-service-treatment-case-detail.component.html',
  styleUrls: ['./customer-service-treatment-case-detail.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class CustomerServiceTreatmentCaseDetailComponent implements OnInit {

  @Input()
  treatmentCase:TreatmentCase;
  @Input()
  medicalTestReportList:any[];
  @Input()
  medicineInfoData:any[];

  onViewMedicalTestReport(medicalTestReport)
  {

  }

  constructor() { }

  ngOnInit() {
  }

}
