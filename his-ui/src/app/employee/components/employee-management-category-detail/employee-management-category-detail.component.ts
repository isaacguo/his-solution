import {ChangeDetectionStrategy, Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {EmployeeListItem} from "../../../core/models/employee/employee-list-item.model";
import {MyTreeNode} from "../../../core/models/my-tree-node.model";
import {Observable} from "rxjs/Observable";

@Component({
  selector: 'app-employee-management-category-detail',
  templateUrl: './employee-management-category-detail.component.html',
  styleUrls: ['./employee-management-category-detail.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class EmployeeManagementCategoryDetailComponent implements OnInit {

  @Input()
  rootNode: Observable<MyTreeNode[]>;

  @Input()
  manager: EmployeeListItem;
  @Input()
  employeeList: EmployeeListItem[];

  @Output()
  employeeViewed = new EventEmitter<EmployeeListItem>();
  @Output()
  employeeEdited = new EventEmitter<EmployeeListItem>();
  @Output()
  employeeRemoved = new EventEmitter<EmployeeListItem>();
  @Output()
  employeeDepartmentAdjusted = new EventEmitter<EmployeeListItem>();
  @Output()
  employeeManagerSet = new EventEmitter<EmployeeListItem>();

  constructor() {
  }

  ngOnInit() {
  }

  onEmployeeViewed(event)
  {
    this.employeeViewed.emit(event);
  }
  onEmployeeEdited(event)
  {
    this.employeeEdited.emit(event);
  }


  onEmployeeRemoved(event)
  {
    this.employeeRemoved.emit(event);
  }

  onEmployeeDepartmentAdjusted(event)
  {
    this.employeeDepartmentAdjusted.emit(event);
  }
  onEmployeeManagerSet(event)
  {
    this.employeeManagerSet.emit(event);
  }

}
