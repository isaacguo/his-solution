import { Component, OnInit } from '@angular/core';
import {ProcurementStatusService} from "../../../../services/business/procurement/procurement-status.service";
import {ProcurementStatus} from "../../../../dto/procurement/procurement-status.model";

@Component({
  selector: 'app-procurement-status',
  templateUrl: './procurement-status.component.html',
  styleUrls: ['./procurement-status.component.css']
})
export class ProcurementStatusComponent implements OnInit {


  p:ProcurementStatus;

  constructor(private procurementStatusService:ProcurementStatusService) { }

  ngOnInit() {
    this.procurementStatusService.getRoot().subscribe(r=>{
      this.p=r;
    })
  }

}
