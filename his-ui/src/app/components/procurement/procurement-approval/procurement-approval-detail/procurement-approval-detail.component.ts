import {Component, Input, OnInit, ViewChild} from '@angular/core';
import {Procurement} from "../../../../dto/procurement/procurement.model";
import {ProcurementApprovalService} from "../../../../services/procurement/procurement-approval.service";
import {ProcurementApprovalOperationRequest} from "../../../../dto/procurement/procurement-approval-operation-request.model";
import {ModalComponent} from "ng2-bs3-modal/ng2-bs3-modal";
import {ProcurementApprovalListComponent} from "../procurement-approval-list/procurement-approval-list.component";
import {Router} from "@angular/router";

@Component({
  selector: 'app-procurement-approval-detail',
  templateUrl: './procurement-approval-detail.component.html',
  styleUrls: ['./procurement-approval-detail.component.css']
})
export class ProcurementApprovalDetailComponent implements OnInit {

  @ViewChild("confirmCreateModal")
  confirmCreateModal:ModalComponent;
  approvalConfirmResultText:string;

  @Input()
  procurement:Procurement;

  constructor(private procurementApprovalService:ProcurementApprovalService, private router:Router, private procurementApprovalListComponent:ProcurementApprovalListComponent) { }

  ngOnInit() {
  }

  onPassButtonClicked() {
    const request= new ProcurementApprovalOperationRequest();
    request.reviewResult=true;
    request.id=this.procurement.id;
    this.procurementApprovalService.updateApproval(request).subscribe(r=>{
      if(r===true)
        this.approvalConfirmResultText="审核提交成功"
        this.confirmCreateModal.open();
    })
  }

  onConfirmCreateModalClosed(){
    //this.router.navigate(['procurement-approval','list']);
    this.procurementApprovalListComponent.procurementStatusChanged();
  }
}
