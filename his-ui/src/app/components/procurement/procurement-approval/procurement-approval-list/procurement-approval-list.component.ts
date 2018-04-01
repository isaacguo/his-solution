import { Component, OnInit } from '@angular/core';
import {ProcurementApproval} from "../../../../dto/procurement/procurement-approval.model";
import {ProcurementApprovalService} from "../../../../services/procurement/procurement-approval.service";
import {Procurement} from "../../../../dto/procurement/procurement.model";

@Component({
  selector: 'app-procurement-approval-list',
  templateUrl: './procurement-approval-list.component.html',
  styleUrls: ['./procurement-approval-list.component.css']
})
export class ProcurementApprovalListComponent implements OnInit {

  procurements:Procurement[];
  selectedProcurement: Procurement;

  constructor(private procurementApprovalService:ProcurementApprovalService) { }

  ngOnInit() {
    this.procurementApprovalService.findMyUnfinishedApprovals().subscribe(r=>{
      this.procurements=r;
    });
  }

  onRowClicked(procurement:Procurement)
  {
    this.selectedProcurement=procurement;
  }

  isRowSelected(procurement: Procurement): boolean {
    return this.selectedProcurement == procurement;
  }


}
