import { Component, OnInit } from '@angular/core';
import {EmploymentStatusEnum} from "../../../core/enums/employment-status.enum";

@Component({
  selector: 'app-finance-container',
  templateUrl: './finance-container.component.html',
  styleUrls: ['./finance-container.component.css']
})
export class FinanceContainerComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  selectedStatusText: string = this.getEmployeeStatusList()[0][1];

  onStatusClicked(status: string) {
    this.selectedStatusText = EmploymentStatusEnum[status];
  }

  getEmployeeStatusList(): [string, string][] {
    let arr: any;

    arr = Object.keys(EmploymentStatusEnum).map(k => {
      return [k, EmploymentStatusEnum[k as any]]
    });
    return arr;

  }

}
