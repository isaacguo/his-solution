import {Component, Input, OnInit, ViewChild} from '@angular/core';
import {ModalComponent} from "ng2-bs3-modal/ng2-bs3-modal";

@Component({
  selector: 'app-inventory-query-category-detail',
  templateUrl: './inventory-query-category-detail.component.html',
  styleUrls: ['./inventory-query-category-detail.component.css']
})
export class InventoryQueryCategoryDetailComponent implements OnInit {

  @Input()
  canCreateNewItem: boolean = true;
  @Input()
  canDelete: boolean = true;
  @Input()
  canEdit: boolean = true;
  @Input()
  canShowAmount: boolean = false;

  @ViewChild("confirmDeletionModal") confirmDeletionModal: ModalComponent;

  @Input()
  categoryName: string;
  @Input()
  categoryId: number;

  itemToBeDeleted: any;

  constructor() { }

  ngOnInit() {
  }

}
