import {Component, OnInit, ViewChild} from '@angular/core';
import {OperationEnum} from "../../../../enums/operation.enum";
import {Router} from "@angular/router";
import {MedicalTestReportService} from "../../../../services/medical-test/medical-test-report.service";
import {MedicalTestReport} from "../../../../dto/medical-test/medical-test-report.model";
import {ModalComponent} from "ng2-bs3-modal/ng2-bs3-modal";

@Component({
  selector: 'app-medical-test-settings-report',
  templateUrl: './medical-test-settings-report.component.html',
  styleUrls: ['./medical-test-settings-report.component.css']
})
export class MedicalTestSettingsReportComponent implements OnInit {

  @ViewChild("confirmDeletionModal") confirmDeletionModal: ModalComponent;
  medicalTestReports: MedicalTestReport[];

  constructor(public router: Router, private medicalTestReportService: MedicalTestReportService) {

  }

  ngOnInit() {
    this.loadData();
  }

  loadData() {
    this.medicalTestReportService.findAll().subscribe(r => {
      this.medicalTestReports = r;
    })
  }

  onCreateNewReportClicked() {
    this.router.navigate(['medical-test-settings', 'reports', OperationEnum.CREATE]);
  }


  onEditButtonClicked(report:MedicalTestReport) {
    this.router.navigate(['medical-test-settings', 'reports', OperationEnum.UPDATE, report.id]);
  }

  reportToBeDeleted:MedicalTestReport;
  removeReport(report: MedicalTestReport) {

    this.reportToBeDeleted = report;
    this.confirmDeletionModal.open();
  }

  onConfirmDeletionModalClosed()
  {
    this.medicalTestReportService.deleteById(this.reportToBeDeleted.id).subscribe(r=>{
      this.loadData();
    })
  }
}
