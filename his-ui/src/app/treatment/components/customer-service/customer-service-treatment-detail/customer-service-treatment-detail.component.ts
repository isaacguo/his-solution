import {Component, Input, OnInit} from '@angular/core';
import {TreatmentCase} from "../../../models/treatment-case.model";

@Component({
  selector: 'app-customer-service-treatment-detail',
  templateUrl: './customer-service-treatment-detail.component.html',
  styleUrls: ['./customer-service-treatment-detail.component.css']
})
export class CustomerServiceTreatmentDetailComponent implements OnInit {

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
