import {Component, OnInit} from '@angular/core';
import {ProcurementApprovalService} from "../../../services/procurement-approval.service";

@Component({
  selector: 'app-procurement-workflow',
  templateUrl: './procurement-workflow.component.html',
  styleUrls: ['./procurement-workflow.component.css']
})
export class ProcurementWorkflowComponent implements OnInit {

  approvalStages: String[]=[];

  constructor(private procurementApprovalService: ProcurementApprovalService) {
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

}
