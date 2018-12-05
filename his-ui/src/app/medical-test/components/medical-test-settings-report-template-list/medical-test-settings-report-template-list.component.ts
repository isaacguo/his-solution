import {Component, OnInit} from '@angular/core';
import {AbstractItemSelectableTableComponent} from "../../../shared/components/abstract-item-selectable-table/abstract-item-selectable-table.component";

@Component({
  selector: 'app-medical-test-settings-report-template-list',
  templateUrl: './medical-test-settings-report-template-list.component.html',
  styleUrls: ['./medical-test-settings-report-template-list.component.css']
})
export class MedicalTestSettingsReportTemplateListComponent extends AbstractItemSelectableTableComponent<any> implements OnInit {


  constructor() {
    super();
  }

  ngOnInit() {
  }

}
