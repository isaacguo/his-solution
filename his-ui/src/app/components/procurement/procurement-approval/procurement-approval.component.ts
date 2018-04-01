import {Component, OnInit} from '@angular/core';
import {ProcurementApprovalService} from "../../../services/procurement/procurement-approval.service";
import {ProcurementApproval} from "../../../dto/procurement/procurement-approval.model";
import {Procurement} from "../../../dto/procurement/procurement.model";

@Component({
  selector: 'app-procurement-approval',
  templateUrl: './procurement-approval.component.html',
  styleUrls: ['./procurement-approval.component.css']
})
export class ProcurementApprovalComponent implements OnInit {



  constructor() {
  }

  ngOnInit() {
  }


}
