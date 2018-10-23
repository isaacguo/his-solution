import {Component, OnInit} from '@angular/core';
import {AbstractCategoryTreeComponent} from "../../../shared/components/abstract-category-tree/abstract-category-tree.component";

@Component({
  selector: 'app-inventory-category-tree',
  templateUrl: './inventory-category-tree.component.html',
  styleUrls: ['./inventory-category-tree.component.css']
})
export class InventoryCategoryTreeComponent extends AbstractCategoryTreeComponent implements OnInit {


  constructor() {
    super();
  }

  ngOnInit() {
  }


}
