import { Component, OnInit } from '@angular/core';
import {TreeNodeService} from "../../../core/services/common/tree-node.service";
import {ActivatedRoute, Router} from "@angular/router";
import {BehaviorSubject} from "rxjs/BehaviorSubject";
import {EmployeeDepartmentService} from "../../../core/services/employee/employee-department.service";
import {Observable} from "rxjs/Observable";
import {MyTreeNode} from "../../../core/models/my-tree-node.model";

@Component({
  selector: 'app-medical-test-settings-department-container',
  templateUrl: './medical-test-settings-department-container.component.html',
  styleUrls: ['./medical-test-settings-department-container.component.css']
})
export class MedicalTestSettingsDepartmentContainerComponent implements OnInit {

  rootNode: Observable<MyTreeNode[]>;
  selectedNodeSubject = new BehaviorSubject<MyTreeNode | null>(null);

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
    this.employeeDepartmentService.getRootDepartment();
  }

  onNodeSelected(event) {
    this.selectedNodeSubject.next(event);
    this.router.navigate([ event.id], {relativeTo: this.route});
  }

  ngOnInit() {
  }


}
