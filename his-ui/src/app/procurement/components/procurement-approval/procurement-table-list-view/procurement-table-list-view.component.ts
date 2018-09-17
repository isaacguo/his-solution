import {Component, Input, OnInit} from '@angular/core';
import {ProcurementApproval} from "../../../models/procurement-approval.model";
import {ProcurementApprovalService} from "../../../services/procurement-approval.service";

@Component({
  selector: 'app-procurement-table-list-view',
  templateUrl: './procurement-table-list-view.component.html',
  styleUrls: ['./procurement-table-list-view.component.css']
})
export class ProcurementTableListViewComponent implements OnInit {

  @Input()
  approvalList: ProcurementApproval[];

  approvalStages: string[]=[];

  isPanelView: boolean = false;

  constructor(private procurementApprovalService: ProcurementApprovalService) {
  }

  getStatusText(): string {

    const index = this.approvalList.findIndex(r => r.reviewed == false);
    if (index == -1)
      return "审批流程已完成";
    else {
      return "等待" + this.approvalList[index].stage + "审批";
    }
  }

  ngOnInit() {
    this.procurementApprovalService.getRoot().subscribe(r => {
      if(r!=null)
        this.approvalStages.push(r.stage);
      while (r.nextStage != null) {
        r = r.nextStage;
        this.approvalStages.push(r.stage);
      }
    });
  }

  getApprovalText(approval: ProcurementApproval): string {
    if (!approval.reviewed)
      return "";
    else if (approval.reviewResult) {
      return "同意";
    }
    else {
      return "退回";
    }
  }

  onShowPanelViewClicked() {
    this.isPanelView = true;
  }

  onShowTableViewClicked() {
    this.isPanelView = false;
  }

}
