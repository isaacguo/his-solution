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
export class ProcurementPurchaseDetailComponent implements OnInit, OnChanges {

  curP:ProcurementStatus;

  pRoot: ProcurementStatus;
  flatenP: ProcurementStatus[] = [];
  selectedStatus:string;
  @Input()
  procurement: Procurement;

  constructor(private procurementStatusService: ProcurementStatusService) {
  }

  ngOnChanges(changes: SimpleChanges): void {


    if (this.pRoot == null) return;
    this.selectedStatus=(<Procurement>changes.procurement.currentValue).status;
    this.findNode(this.pRoot,this.selectedStatus);
    this.flatenP=[];
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
      console.log("return");
      this.curP=p;
      return;
    }
    else if (p.next != null && p.next.length > 0) {
      console.log("in 50");
      p.next.forEach(r => {
        this.findNode(r, status);
      });
    }
  }

  onStatusDropdownClicked(status:string) {
    this.selectedStatus=status;
  }

  private iterateP(p: ProcurementStatus) {

    if(p.next!=null)
    {
      p.next.forEach(r=>{
        this.flatenP.push(r.status);
      })
    }
  }
}
