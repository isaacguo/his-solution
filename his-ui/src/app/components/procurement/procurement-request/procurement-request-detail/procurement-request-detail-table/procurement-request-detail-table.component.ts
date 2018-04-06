import {Component, Input, OnInit} from '@angular/core';
import {Procurement} from "../../../../../dto/procurement/procurement.model";

@Component({
  selector: 'app-procurement-request-detail-table',
  templateUrl: './procurement-request-detail-table.component.html',
  styleUrls: ['./procurement-request-detail-table.component.css']
})
export class ProcurementRequestDetailTableComponent implements OnInit {


  @Input()
  procurement:Procurement;

  constructor() { }

  ngOnInit() {
  }

}
