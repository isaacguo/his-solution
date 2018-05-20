import {Component, OnInit, ViewChild} from '@angular/core';
import {ModalComponent} from "ng2-bs3-modal/ng2-bs3-modal";
import {MedicalTestReportService} from "../../../services/medical-test/medical-test-report.service";
import {Router} from "@angular/router";
import {OperationEnum} from "../../../enums/operation.enum";

@Component({
  selector: 'app-medical-test-query',
  templateUrl: './medical-test-query.component.html',
  styleUrls: ['./medical-test-query.component.css']
})
export class MedicalTestQueryComponent implements OnInit {

  @ViewChild("chooseReportTypeModal") chooseReportTypeModal: ModalComponent;
  reports: any = [];

  constructor(private router: Router, private medicalTestReportService: MedicalTestReportService) {
  }


  ngOnInit() {

  }

  onChooseReportTypeModalClosed() {
    this.router.navigate(['medical-test-report', OperationEnum.CREATE, this.selectedReportType.id]);

    this.selectedReportType =null;
  }

  onCreateNewReport() {

    this.selectedReportType =null;

    this.medicalTestReportService.findAll().subscribe(r => {
      this.reports = r;
      this.chooseReportTypeModal.open();
    })
  }

  selectedReportType: any=null;

  onReportTypeSelected(report: any) {
    this.selectedReportType = report;
  }

  isRowSelected(report: any) {
    return this.selectedReportType === report;
  }
}
