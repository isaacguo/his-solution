import {Component, OnInit, ViewChild} from '@angular/core';
import {TreeComponent} from "angular-tree-component";
import {MyTreeNode} from "../../../../../core/models/my-tree-node.model";
import {EmployeeDepartmentService} from "../../../../../core/services/employee-department.service";

@Component({
  selector: 'app-medical-test-settings-department-list',
  templateUrl: './medical-test-settings-department-list.component.html',
  styleUrls: ['./medical-test-settings-department-list.component.css']
})
export class MedicalTestSettingsDepartmentListComponent implements OnInit {

  constructor(private employeeDepartmentService: EmployeeDepartmentService) { }
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
