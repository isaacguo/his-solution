import {ChangeDetectionStrategy, Component, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {AbstractCategoryTreeComponent} from "../../../shared/components/abstract-category-tree/abstract-category-tree.component";

@Component({
  selector: 'app-employee-management-category-tree',
  templateUrl: './employee-management-category-tree.component.html',
  styleUrls: ['./employee-management-category-tree.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class EmployeeManagementCategoryTreeComponent extends AbstractCategoryTreeComponent implements OnInit {


  constructor() {
    super();
  }


  ngOnInit() {
  }

  onUpdateData(event) {
    this.expandTree();
  }

}
