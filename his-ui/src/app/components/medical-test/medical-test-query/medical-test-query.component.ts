import {Component, OnInit, ViewChild} from '@angular/core';
import {ModalComponent} from "ng2-bs3-modal/ng2-bs3-modal";
import {MedicalTestReportTemplateService} from "../../../services/medical-test/medical-test-report-template.service";
import {Router} from "@angular/router";
import {OperationEnum} from "../../../enums/operation.enum";
import {MedicalTestReportService} from "../../../services/medical-test/medical-test-report.service";

@Component({
  selector: 'app-medical-test-query',
  templateUrl: './medical-test-query.component.html',
  styleUrls: ['./medical-test-query.component.css']
})
export class MedicalTestQueryComponent implements OnInit {

  @ViewChild("chooseReportTypeModal")
  chooseReportTypeModal: ModalComponent;
  reportTemplates: any[] = [];
  reports: any[] = [];

  constructor(private router: Router,
              private medicalTestReportService: MedicalTestReportService,
              private medicalTestReportTemplateService: MedicalTestReportTemplateService) {

  }


  ngOnInit() {
    this.loadData();
  }


  onChooseReportTypeModalClosed() {

    this.router.navigate(['medical-test-report', OperationEnum.CREATE, this.selectedReportType.id]);
    this.selectedReportType = null;
  }

  onCreateNewReport() {

    this.selectedReportType = null;

    this.medicalTestReportTemplateService.findAll().subscribe(r => {
      this.reportTemplates = r;
      this.chooseReportTypeModal.open();
    })
  }

  selectedReportType: any = null;

  onReportTypeSelected(report: any) {
    this.selectedReportType = report;
  }

  isRowSelected(report: any) {
    return this.selectedReportType === report;
  }

  private loadData() {
    this.medicalTestReportService.findAll().subscribe(r => {
      this.reports = r as any[];
    })

  }

  onModifyButtonClicked(report: any) {
    this.router.navigate(['medical-test-report', OperationEnum.UPDATE, report.id]);
  }

  onRemoveButtonClicked(report: any) {

  }

  onModifyStatusButtonClicked(report: any) {


  }
}
