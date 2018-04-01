import { Component, OnInit } from '@angular/core';
import {ProcurementApprovalService} from "../../../services/procurement/procurement-approval.service";
import {ProcurementApproval} from "../../../dto/procurement/procurement-approval.model";

@Component({
  selector: 'app-procurement-approval',
  templateUrl: './procurement-approval.component.html',
  styleUrls: ['./procurement-approval.component.css']
})
export class ProcurementApprovalComponent implements OnInit {

  procurementApproval:ProcurementApproval[];

  constructor(private procurementApprovalService:ProcurementApprovalService) { }

  ngOnInit() {
    this.procurementApprovalService.findMyUnfinishedApprovals().subscribe(r=>{
      this.procurementApproval=r;
    });
  }

}
