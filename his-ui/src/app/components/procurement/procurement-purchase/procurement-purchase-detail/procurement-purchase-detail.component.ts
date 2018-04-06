import {Component, Input, OnInit} from '@angular/core';
import {Procurement} from "../../../../dto/procurement/procurement.model";

@Component({
  selector: 'app-procurement-purchase-detail',
  templateUrl: './procurement-purchase-detail.component.html',
  styleUrls: ['./procurement-purchase-detail.component.css']
})
export class ProcurementPurchaseDetailComponent implements OnInit {

  @Input()
  procurement:Procurement;

  constructor() { }

  ngOnInit() {
  }

}
