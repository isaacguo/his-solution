import {Component, Input, OnInit} from '@angular/core';
import {FormGroup} from "@angular/forms";

@Component({
  selector: 'app-procurement-purchase-good-create-update',
  templateUrl: './procurement-purchase-good-create-update.component.html',
  styleUrls: ['./procurement-purchase-good-create-update.component.css']
})
export class ProcurementPurchaseGoodCreateUpdateComponent implements OnInit {

  @Input('good')
  public good: FormGroup;

  constructor() {
  }

  ngOnInit() {
  }

}
