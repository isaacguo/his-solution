import {ChangeDetectionStrategy, Component, OnInit, ViewChild} from '@angular/core';
import {Observable} from "rxjs/Observable";
import {MyTreeNode} from "../../../core/models/my-tree-node.model";
import {BehaviorSubject} from "rxjs/BehaviorSubject";
import {EmployeeDepartmentService} from "../../../core/services/employee/employee-department.service";
import {TreeNodeService} from "../../../core/services/common/tree-node.service";
import {ActivatedRoute, Router} from "@angular/router";
import {EmployeeManagementCategoryTreeComponent} from "../../components/employee-management-category-tree/employee-management-category-tree.component";

@Component({
  selector: 'app-employee-management-tree-view-container',
  templateUrl: './employee-management-tree-view-container.component.html',
  styleUrls: ['./employee-management-tree-view-container.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class EmployeeManagementTreeViewContainerComponent implements OnInit {

  rootNode: Observable<MyTreeNode[]>;
  selectedNodeSubject = new BehaviorSubject<MyTreeNode>(new MyTreeNode());

  @ViewChild("tree")
  appEmployeeManagementCategoryTree: EmployeeManagementCategoryTreeComponent;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private employeeDepartmentService: EmployeeDepartmentService,
    private treeNodeService: TreeNodeService) {
    this.rootNode = this.employeeDepartmentService.getObservableRootDepartment().map(res => this.treeNodeService.treeConverter(res, true)).map(node => {
      let arr: MyTreeNode[] = [];
      arr.push(node);
      return arr;
    });
  }

  ngOnInit() {
    this.employeeDepartmentService.getRootDepartment();
  }

  onNodeSelected(event) {
    this.selectedNodeSubject.next(event);
    this.router.navigate(['departments', event.id], {relativeTo: this.route});
  }

  getSelectedNode(): Observable<MyTreeNode> {
    return this.selectedNodeSubject.asObservable();
  }

  getNodes(): Observable<MyTreeNode[]> {
    return this.rootNode;
  }


  onNodeDeleted(event: MyTreeNode) {
    this.employeeDepartmentService.deleteDepartment(event.id);


  }

  onNodeUpdated(event: MyTreeNode) {

  }

  onNodeExpanded() {
    this.appEmployeeManagementCategoryTree.expandTree();
  }

  onRootNodeCreated($event: MyTreeNode) {
  }

  onSubNodeCreated(event: MyTreeNode) {
    this.employeeDepartmentService.createDepartment(event.id, event.name)
  }



}
