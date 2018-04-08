import {Component, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {Procurement} from "../../../../dto/procurement/procurement.model";
import {ProcurementStatusService} from "../../../../services/procurement/procurement-status.service";
import {ProcurementStatus} from "../../../../dto/procurement/procurement-status.model";
import {forEach} from "@angular/router/src/utils/collection";
import {findNode} from "@angular/compiler";

@Component({
  selector: 'app-procurement-purchase-detail',
  templateUrl: './procurement-purchase-detail.component.html',
  styleUrls: ['./procurement-purchase-detail.component.css']
})
export class ProcurementPurchaseDetailComponent implements OnInit {


  /*
  ngOnChanges(changes: SimpleChanges): void {
    this.findNode(changes.procurement.currentValue);
    console.log("ppp" + this.curP);

    this.iterateP(this.curP);
  }
  */

  pRoot: ProcurementStatus;
  curP: ProcurementStatus;
  flatenP: ProcurementStatus[] = [];

  @Input()
  procurement:Procurement;


  constructor(private procurementStatusService: ProcurementStatusService) {
  }

  ngOnInit() {
    this.procurementStatusService.getRoot().subscribe(r => {
      this.pRoot = r;
      console.log(this.pRoot);
    })
  }

  findNode(p: ProcurementStatus) {
    if (this.pRoot.status === p.status) {
      this.curP = p;
      return;
    }
    else if (p.next != null && p.next.length > 0) {
      p.next.forEach(r => {
        this.findNode(r);
      })
    }
  }

  private iterateP(p: ProcurementStatus) {
    this.flatenP.push(p.status);
    if (p.next != null && p.next.length > 0) {
      p.next.forEach(r => {
        this.iterateP(r);
      })
    }
  }

  onStatusDropdownClicked(status: ProcurementStatus) {


  }
}
