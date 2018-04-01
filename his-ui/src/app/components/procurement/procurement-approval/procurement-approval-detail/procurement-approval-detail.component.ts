import {Component, Input, OnInit} from '@angular/core';
import {Procurement} from "../../../../dto/procurement/procurement.model";
import {ProcurementApprovalService} from "../../../../services/procurement/procurement-approval.service";
import {ProcurementApprovalOperationRequest} from "../../../../dto/procurement/procurement-approval-operation-request.model";

@Component({
  selector: 'app-procurement-approval-detail',
  templateUrl: './procurement-approval-detail.component.html',
  styleUrls: ['./procurement-approval-detail.component.css']
})
export class ProcurementApprovalDetailComponent implements OnInit {

  @Input()
  procurement:Procurement;

  constructor(private procurementApprovalService:ProcurementApprovalService) { }

  ngOnInit() {
  }

  onPassButtonClicked() {
    const request= new ProcurementApprovalOperationRequest();
    request.reviewResult=true;
    request.id=this.procurement.id;
    this.procurementApprovalService.updateApproval(request).subscribe(r=>{
      console.log(r);
    })
  }
}
