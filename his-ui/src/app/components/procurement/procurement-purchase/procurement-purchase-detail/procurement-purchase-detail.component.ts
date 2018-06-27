import {Component, Input, OnChanges, OnDestroy, OnInit, SimpleChanges, ViewChild} from '@angular/core';
import {Procurement} from "../../../../dto/procurement/procurement.model";
import {ProcurementStatusService} from "../../../../services/procurement/procurement-status.service";
import {ProcurementStatus} from "../../../../dto/procurement/procurement-status.model";
import {AuthenticationService, AuthInfo} from "../../../../services/common/authentication.service";
import {Subscription} from "rxjs/Subscription";
import {ProcurementService} from "../../../../services/procurement/procurement.service";
import {ProcurementOperationRequest} from "../../../../dto/procurement/procurement-operation-request.model";
import {ModalComponent} from "ng2-bs3-modal/ng2-bs3-modal";

@Component({
  selector: 'app-procurement-purchase-detail',
  templateUrl: './procurement-purchase-detail.component.html',
  styleUrls: ['./procurement-purchase-detail.component.css']
})
export class ProcurementPurchaseDetailComponent implements OnInit, OnChanges, OnDestroy {

  @ViewChild("confirmUpdatedModal")
  confirmUpdatedModal: ModalComponent;
  authInfo: AuthInfo;
  curP: ProcurementStatus;
  pRoot: ProcurementStatus;
  flatenP: string[] = [];
  selectedStatus: string;
  @Input()
  procurement: Procurement;
  private authChangeSubscription: Subscription;

  constructor(private procurementService: ProcurementService, private procurementStatusService: ProcurementStatusService, private authenticationService: AuthenticationService) {
    this.authChangeSubscription = authenticationService.authChange.subscribe(
      newAuthInfo =>
        this.authInfo = newAuthInfo);
  }

  ngOnDestroy(): void {
    this.authChangeSubscription.unsubscribe();
  }

  ngOnChanges(changes: SimpleChanges): void {

    console.log(this.procurement);

    if (this.pRoot == null) return;
    this.selectedStatus = (<Procurement>changes.procurement.currentValue).status;
    this.findNode(this.pRoot, this.selectedStatus);
    this.flatenP = [];
    this.iterateP(this.curP);
  }

  ngOnInit() {

    this.procurementStatusService.getRoot().subscribe(r => {
      this.pRoot = r;
    })
  }

  findNode(p: ProcurementStatus, status: string) {
    console.log(p.status);
    console.log(status);
    if (p.status === status) {
      this.curP = p;
      return;
    }
    else if (p.next != null && p.next.length > 0) {
      p.next.forEach(r => {
        this.findNode(r, status);
      });
    }
  }

  onStatusDropdownClicked(status: string) {
    this.selectedStatus = status;
  }

  hasAlterPermission(): boolean {
    return true;
    /*
    if(this.procurement.procurementPurchase==null) return false;
    if(this.procurement.procurementPurchase.assignTo===this.authInfo.displayName)
      return true;
    else
      return false;
      */
  }

  private iterateP(p: ProcurementStatus) {

    if (p.next != null) {
      p.next.forEach(r => {
        this.flatenP.push(r.status);
      })
    }
  }

  onUpdateStatusButtonClicked() {
    const request = new ProcurementOperationRequest();
    request.id = this.procurement.id;
    request.status = this.selectedStatus;

    this.procurementService.updateStatus(request).subscribe(r => {
      this.confirmUpdatedModal.open();
    });
  }

  confirmUpdatedModalClosed() {

  }
}
