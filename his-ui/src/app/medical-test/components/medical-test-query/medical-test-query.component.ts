import {ChangeDetectionStrategy, Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {MedicalTestReport} from "../../models/medical-test-report.model";
import {ReportStatusEnum} from "../../../core/enums/report-status.enum";

@Component({
  selector: 'app-medical-test-query',
  templateUrl: './medical-test-query.component.html',
  styleUrls: ['./medical-test-query.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class MedicalTestQueryComponent implements OnInit {

  @Input()
  pageData: any;
  @Output()
  pageSelected = new EventEmitter<number>();

  @Output()
  modifyMedicalTestReport=new EventEmitter<MedicalTestReport>();

  constructor() { }

  ngOnInit() {
  }

  onModifyButtonClicked(report: MedicalTestReport) {
    this.modifyMedicalTestReport.emit(report);
  }

  onModifyStatusButtonClicked(report: MedicalTestReport) {

  }

  getStatusText(status: any): string {
    return ReportStatusEnum[status];
  }

  onPageChanged($event: number) {
    this.pageSelected.emit($event);
  }
}
