import {Component, OnInit, ViewChild} from '@angular/core';
import {OperationEnum} from "../../../../enums/operation.enum";
import {Router} from "@angular/router";
import {MedicalTestReportTemplateService} from "../../../../services/medical-test/medical-test-report-template.service";
import {MedicalTestReportTemplate} from "../../../../dto/medical-test/medical-test-report-template.model";
import {ModalComponent} from "ng2-bs3-modal/ng2-bs3-modal";

@Component({
  selector: 'app-medical-test-settings-report',
  templateUrl: './medical-test-settings-report.component.html',
  styleUrls: ['./medical-test-settings-report.component.css']
})
export class MedicalTestSettingsReportComponent implements OnInit {
  ngOnInit(): void {
  }


}
