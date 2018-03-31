import {Component, Input, OnInit} from '@angular/core';
import {ProcurementRequest} from "../../../../dto/procurement/procurement-request.model";

@Component({
  selector: 'app-procurement-request-detail',
  templateUrl: './procurement-request-detail.component.html',
  styleUrls: ['./procurement-request-detail.component.css']
})
export class ProcurementRequestDetailComponent implements OnInit {

  @Input()
  procurementRequest:ProcurementRequest;

  constructor() { }

  ngOnInit() {
  }

}
