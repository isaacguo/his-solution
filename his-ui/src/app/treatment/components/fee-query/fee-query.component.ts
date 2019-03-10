import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-fee-query',
  templateUrl: './fee-query.component.html',
  styleUrls: ['./fee-query.component.css']
})
export class FeeQueryComponent implements OnInit {


  @Input()
  pageData: any;
  @Output()
  pageSelected = new EventEmitter<number>();
  @Output()
  transactionStatusChanged = new EventEmitter<any>();

  constructor() {
    this.pageData = [];
  }

  ngOnInit() {
  }

  onPageChanged(event: number) {
    this.pageSelected.emit(event);
  }

  getStatusText(status: any) {
    //return ChargeStatusEnum[status];
  }

  onPaidClicked(chargeItem: any) {
    this.transactionStatusChanged.emit({...chargeItem});
    /*
    this.financeChargeService.updateStatus(chargeItem.id, "PAID").subscribe(r => {
      this.loadData();
    });
    */
  }

  onReimbursedClicked(chargeItem: any) {
    this.transactionStatusChanged.emit({...chargeItem});
  }

  isPaid(status: any) {
    //return this.getStatusText(status)===ChargeStatusEnum.PAID;
  }
}
