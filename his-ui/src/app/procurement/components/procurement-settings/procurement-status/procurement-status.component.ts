import {Component, OnInit} from '@angular/core';
import {ProcurementStatus} from "../../../models/procurement-status.model";
import {ProcurementStatusService} from "../../../services/procurement-status.service";

@Component({
  selector: 'app-procurement-status',
  templateUrl: './procurement-status.component.html',
  styleUrls: ['./procurement-status.component.css']
})
export class ProcurementStatusComponent implements OnInit {


  p: ProcurementStatus;
  flatenP: string[]=[];

  constructor(private procurementStatusService: ProcurementStatusService) {
  }

  ngOnInit() {
    this.procurementStatusService.getRoot().subscribe(r => {
      this.p = r;
      this.iterateP(r);

    })
  }

  private iterateP(p: ProcurementStatus) {
    this.flatenP.push(p.status);
    if (p.next != null && p.next.length>0) {
      p.next.forEach(r => {
        this.iterateP(r);
      })
    }
  }



}
