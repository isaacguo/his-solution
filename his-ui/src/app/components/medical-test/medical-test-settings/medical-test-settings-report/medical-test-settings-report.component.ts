import {Component, Input, OnInit} from '@angular/core';
import {FinanceChargeService} from "../../../../services/finance/finance-charge.service";

@Component({
  selector: 'app-medical-test-settings-report',
  templateUrl: './medical-test-settings-report.component.html',
  styleUrls: ['./medical-test-settings-report.component.css']
})
export class MedicalTestSettingsReportComponent implements OnInit {

  @Input()
  showToolBox: boolean = true;
  @Input()
  showTitle: boolean = true;
  @Input()
  canCreateNewItem: boolean = true;
  @Input()
  canDelete: boolean = true;
  @Input()
  canEdit: boolean = true;
  @Input()
  financeChargeService: FinanceChargeService;

  ngOnInit(): void {
  }


}
