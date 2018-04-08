import {Component, OnInit} from '@angular/core';
import {ProcurementStatusService} from "../../../../services/procurement/procurement-status.service";
import {ProcurementStatus} from "../../../../dto/procurement/procurement-status.model";

@Component({
  selector: 'app-procurement-status',
  templateUrl: './procurement-status.component.html',
  styleUrls: ['./procurement-status.component.css']
})
export class ProcurementStatusComponent implements OnInit {


  p: ProcurementStatus;
  flatenP: ProcurementStatus[]=[];

  constructor(private procurementStatusService: ProcurementStatusService) {
  }

  ngOnInit() {
    this.procurementStatusService.getRoot().subscribe(r => {
      this.p = r;
      this.iterateP(r);
      console.log(this.flatenP);

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

  public org_ChartData = [
    ['Name', 'Manager', 'ToolTip'],
    [{v: 'Mike', f: 'Mike<div style="color:red; font-style:italic">President</div>'},
      '', 'The President'],
    [{v: 'Jim', f: 'Jim<div style="color:red; font-style:italic">Vice President</div>'},
      'Mike', 'VP'],
    ['Alice', 'Mike', ''],
    ['Bob', 'Jim', 'Bob Sponge'],
    ['Carol', 'Bob', '']
  ];

  public org_ChartOptions = {
    allowHtml: true
  };

}