import {Component, Input, OnInit} from '@angular/core';
import {ProcurementRequest} from "../../../../dto/procurement/procurement-request.model";
import {Procurement} from "../../../../dto/procurement/procurement.model";

@Component({
  selector: 'app-procurement-request-detail',
  templateUrl: './procurement-request-detail.component.html',
  styleUrls: ['./procurement-request-detail.component.css']
})
export class ProcurementRequestDetailComponent implements OnInit {

  @Input()
  procurement:Procurement;
  @Input()
  approvalStages:string[];

  isPanelview:boolean=false;


  constructor() { }

  ngOnInit() {
  }

  getStatusText():string {

    const index=this.procurement.approvalList.findIndex(r=>r.reviewed==false);
    if(index==-1)
      return "审批流程已完成";
    else {
      return "等待"+this.procurement.approvalList[index].stage+"审批";
    }
  }

  onShowPanelViewClicked() {
    this.isPanelview=true;
  }

  onShowTableViewClicked() {
    this.isPanelview=false;
  }
}
