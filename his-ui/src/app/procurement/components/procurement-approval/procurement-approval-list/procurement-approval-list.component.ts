import {Component, OnInit} from '@angular/core';
import {ProcurementApprovalService} from "../../../services/procurement-approval.service";
import {Procurement} from "../../../models/procurement.model";

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
    this.loadData();
  }

  public procurementStatusChanged()
  {
    this.loadData();
  }

  private loadData() {
    this.selectedProcurement=null;
    this.procurementApprovalService.findMyUnfinishedApprovals().subscribe(r => {
      this.procurements = r;
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
