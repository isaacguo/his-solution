import {Component, OnInit, ViewChild} from '@angular/core';
import {FormControl} from "@angular/forms";
import {TreeComponent} from "angular-tree-component";
import {ModalComponent} from "ng2-bs3-modal/ng2-bs3-modal";
import {MyTreeNode} from "../../../../core/models/my-tree-node.model";
import {EmployeeDepartmentService} from "../../../../core/services/employee-department.service";
import {TreeNodeService} from "../../../../core/services/common/tree-node.service";
import {TreeviewOperationEnum} from "../../../../core/enums/treeview-operation.enum";

@Component({
  selector: 'app-employee-admin-list',
  templateUrl: './employee-admin-list.component.html',
  styleUrls: ['./employee-admin-list.component.css']
})
export class EmployeeAdminListComponent implements OnInit {


  nodeOperation: TreeviewOperationEnum;

  nodes: MyTreeNode[] = [];

  departmentName: FormControl = new FormControl('');

  @ViewChild("editNodeModal")
  editNodeModal: ModalComponent;

  @ViewChild(TreeComponent)
  tree: TreeComponent;

  @ViewChild("confirmDeleteModal")
  confirmDeleteModal: ModalComponent;
  selectedNodeName: string;
  selectedDepartmentId: number;

  constructor(private employeeDepartmentService: EmployeeDepartmentService, private treeNodeService: TreeNodeService) {
  }

  ngOnInit() {
    this.loadData();
  }

  private loadData() {
    this.employeeDepartmentService.getRootDepartment().subscribe(r => {
      this.nodes.splice(0, this.nodes.length);
      this.nodes.push(r);
      this.tree.treeModel.update();
      this.tree.treeModel.expandAll();
    });
  }

  removeSelectedNode() {

    const nodeId = this.tree.treeModel.getActiveNode().id;
    const index = this.tree.treeModel.getActiveNode().index;
    let cnode: MyTreeNode = this.treeNodeService.getMyTreeNodeById(this.nodes, nodeId);
    this.employeeDepartmentService.deleteDepartment(cnode.categoryId).subscribe(r => {
      this.loadData()
    });


    /*
    if (cnode.isLevelOne) {
      this.nodes.splice(index, 1);
    }
    else {
      let parentId = this.tree.treeModel.getActiveNode().parent.id;
      let pMyTreeNode: MyTreeNode = this.getMyTreeNodeById(parentId);
      pMyTreeNode.children.splice(index, 1);
    }
    this.tree.treeModel.update();
    */

  }

  onCreateRootNode() {
    const newRootNode = new MyTreeNode();
    newRootNode.name = this.departmentName.value;
    newRootNode.isLevelOne = true;
    this.nodes.push(newRootNode);
    this.tree.treeModel.update();
  }

  enableWhenNodeIsActivated(): boolean {
    return this.tree.treeModel.getFocusedNode() != null;

  }

  onPreAddChildNodeButtonClicked() {
    this.nodeOperation = TreeviewOperationEnum.CREATE_SUB_NODE;
    this.editNodeModal.open();
  }

  onPreRootNodeButtonClicked() {
    this.nodeOperation = TreeviewOperationEnum.CREATE_HOME_NODE;
    this.editNodeModal.open();
  }

  onPreEditNodeButtonClicked() {

    this.nodeOperation = TreeviewOperationEnum.EDIT_NODE;

    const nodeId = this.tree.treeModel.getActiveNode().id;
    let node = this.treeNodeService.getMyTreeNodeById(this.nodes, nodeId);
    this.departmentName.setValue(node.name);

    this.editNodeModal.open();
  }

  /*
  onAddSubNode() {

    const nodeId = this.tree.treeModel.getActiveNode().id;
    let parentNode = this.getMyTreeNodeById(nodeId);

    const newRootNode = new MyTreeNode();
    newRootNode.name = this.departmentName.value;
    newRootNode.isLevelOne = false;
    if (parentNode.children == null)
      parentNode.children = [];

    parentNode.children.push(newRootNode);
    this.tree.treeModel.update();

    this.tree.treeModel.getActiveNode().expand();

  }
  */

  addNodeToParent(parent: MyTreeNode) {

  }

  onNodeActivated($event) {
    this.getSelectedNodeName();
  }

  onExpandButtonClicked() {
    this.tree.treeModel.expandAll();
  }

  onEditNode() {

    const nodeId = this.tree.treeModel.getActiveNode().id;
    let node = this.treeNodeService.getMyTreeNodeById(this.nodes, nodeId);

    this.employeeDepartmentService.renameDepartment(node.categoryId, this.departmentName.value).subscribe(r => {
      this.loadData();
    });

  }

  onEditNodeModalModalClosed() {
    switch (this.nodeOperation) {
      //case TreeviewOperationEnum.CREATE_HOME_NODE:

      //this.onCreateRootNode();
      // break;
      case TreeviewOperationEnum.CREATE_SUB_NODE:
        this.employeeDepartmentService.createDepartment(this.selectedDepartmentId, this.departmentName.value).subscribe(r => {
          this.loadData()
        });
        break;
      case TreeviewOperationEnum.EDIT_NODE:
        this.onEditNode();
        break;
      default: {

      }
    }
    this.departmentName.setValue("");
    this.nodeOperation = 0;
  }

  onConfirmDeleteModalClosed() {
    this.removeSelectedNode();

  }

  getSelectedNodeName() {
    if (this.tree.treeModel.getActiveNode() != null) {
      const nodeId = this.tree.treeModel.getActiveNode().id;
      let node = this.treeNodeService.getMyTreeNodeById(this.nodes, nodeId);
      this.selectedNodeName = node.name;
      this.selectedDepartmentId = node.categoryId;
    } else return "";
  }

  onPreRemoveNodeButtonClicked() {
    this.confirmDeleteModal.open();
  }

}
