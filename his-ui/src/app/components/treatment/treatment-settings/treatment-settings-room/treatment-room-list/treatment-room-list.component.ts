import {Component, OnInit, ViewChild} from '@angular/core';
import {MyTreeNode} from "../../../../../dto/procurement/MyTreeNode";
import {DepartmentService} from "../../../../../services/treatment/department.service";
import {TreeNodeService} from "../../../../../services/common/tree-node.service";
import {EmployeeDepartmentService} from "../../../../../services/employee/employee-department.service";
import {TreeComponent} from "angular-tree-component";

@Component({
  selector: 'app-treatment-room-list',
  templateUrl: './treatment-room-list.component.html',
  styleUrls: ['./treatment-room-list.component.css']
})
export class TreatmentRoomListComponent implements OnInit {

  constructor(public departmentService:DepartmentService, public treeNodeService:TreeNodeService,private employeeDepartmentService: EmployeeDepartmentService ) { }

  nodes: MyTreeNode[] = [];
  selectedRoomId: number;

  selectedNodeName: string;
  selectedDepartmentId: number;


  @ViewChild(TreeComponent)
  tree: TreeComponent;

  getSelectedNodeName() {
    if (this.tree.treeModel.getActiveNode() != null) {
      const nodeId = this.tree.treeModel.getActiveNode().id;
      let node = this.getMyTreeNodeById(nodeId);
      this.selectedNodeName = node.name;
      this.selectedDepartmentId = node.categoryId;
    } else return "";
  }

  ngOnInit() {
    this.loadData();
  }

  private loadData() {
    this.employeeDepartmentService.getRootDepartment().subscribe(r => {
      this.nodes.splice(0,this.nodes.length);
      this.nodes.push(r);
      this.tree.treeModel.update();
      this.tree.treeModel.expandAll();
    });
  }

  private getMyTreeNodeById(nodeId: any) {
    let parentNode: any;
    for (let cnode of this.nodes) {
      let found = cnode.findById(nodeId);
      if (found != null) {
        parentNode = found;
        break;
      }
    }
    return parentNode;
  }


  onNodeActivated($event) {
    this.getSelectedNodeName();
  }

}