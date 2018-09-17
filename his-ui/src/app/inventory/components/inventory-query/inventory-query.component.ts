import {Component, Input, OnInit} from '@angular/core';
import {FinancePriceService} from "../../../core/services/finance-price.service";

@Component({
  selector: 'app-inventory-query',
  templateUrl: './inventory-query.component.html',
  styleUrls: ['./inventory-query.component.css']
})
export class InventoryQueryComponent implements OnInit {

  @Input()
  showToolBox: boolean = false;
  @Input()
  showTitle: boolean = true;
  @Input()
  canCreateNewItem: boolean = false;
  @Input()
  canDelete: boolean = false;
  @Input()
  canEdit: boolean = false;
  @Input()
  financePriceService: FinancePriceService;

  constructor() { }

  ngOnInit() {
  }


}
