import {Component, Input, OnInit} from '@angular/core';
import {Procurement} from "../../../../models/procurement.model";

@Component({
  selector: 'app-procurement-request-detail-table',
  templateUrl: './procurement-request-detail-table.component.html',
  styleUrls: ['./procurement-request-detail-table.component.css']
})
export class ProcurementRequestDetailTableComponent implements OnInit {


  @Input()
  procurement:Procurement;

  getSubmittedData():Date
  {
    return new Date(this.procurement.procurementRequest.submittedData);
  }

  constructor() { }

  ngOnInit() {
  }

}
