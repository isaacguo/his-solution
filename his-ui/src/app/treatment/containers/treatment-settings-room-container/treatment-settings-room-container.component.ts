import {Component, OnInit} from '@angular/core';
import {MyTreeNode} from "../../../core/models/my-tree-node.model";
import {Observable} from "rxjs/Observable";
import {BehaviorSubject} from "rxjs/BehaviorSubject";
import {TreeNodeService} from "../../../core/services/common/tree-node.service";
import {ActivatedRoute, Router} from "@angular/router";
import {EmployeeDepartmentService} from "../../../core/services/employee/employee-department.service";

@Component({
  selector: 'app-treatment-settings-room-container',
  templateUrl: './treatment-settings-room-container.component.html',
  styleUrls: ['./treatment-settings-room-container.component.css']
})
export class TreatmentSettingsRoomContainerComponent implements OnInit {

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
