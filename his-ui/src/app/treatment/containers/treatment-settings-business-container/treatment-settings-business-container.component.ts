import {Component, Input, OnInit} from '@angular/core';
import {FinancePriceService} from "../../../core/services/finance/finance-price.service";

@Component({
  selector: 'app-treatment-settings-business-container',
  templateUrl: './treatment-settings-business-container.component.html',
  styleUrls: ['./treatment-settings-business-container.component.css']
})
export class TreatmentSettingsBusinessContainerComponent implements OnInit {

  showToolBox: boolean = true;
  showTitle: boolean = true;
  canCreateNewItem: boolean = true;
  canDelete: boolean = true;
  canEdit: boolean = true;
  financePriceService: FinancePriceService;

  constructor() { }

  ngOnInit() {
  }

}
