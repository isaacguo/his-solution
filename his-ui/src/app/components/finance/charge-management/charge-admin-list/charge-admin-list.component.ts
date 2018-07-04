import {Component, OnInit, ViewChild} from '@angular/core';
import {ModalComponent} from "ng2-bs3-modal/ng2-bs3-modal";
import {MyTreeNode} from "../../../../dto/procurement/MyTreeNode";
import {FormControl, Validators} from "@angular/forms";
import {DepartmentListItem} from "../../../../dto/employee/department-list-item.model";
import {TreeComponent} from "angular-tree-component";
import {FinanceChargeCategoryService} from "../../../../services/finance/finance-charge-category.service";

@Component({
  selector: 'app-charge-admin-list',
  templateUrl: './charge-admin-list.component.html',
  styleUrls: ['./charge-admin-list.component.css']
})
export class ChargeAdminListComponent implements OnInit {

  private static CREATE_HOME_NODE: number = 1;
  private static CREATE_SUB_NODE: number = 2;
  private static EDIT_NODE: number = 3;

  nodeOperation: number;
  departmentList: DepartmentListItem[] = [];

  isExpanded: boolean = false;
  isCreateNewNode: boolean = true;

  nodes: MyTreeNode[] = [];

  categoryName: FormControl = new FormControl('', [Validators.required, Validators.minLength(1)]);

  @ViewChild("editNodeModal")
  editNodeModal: ModalComponent;

  @ViewChild(TreeComponent)
  tree: TreeComponent;

  @ViewChild("confirmDeleteModal")
  confirmDeleteModal: ModalComponent;
  selectedNodeName: string;
  selectedCategoryId: number;

  constructor(private financeChargeCategoryService: FinanceChargeCategoryService) {

  }

  ngOnInit() {
    this.loadData();
  }

  private loadData() {
    this.financeChargeCategoryService.getRootChargeCategory().subscribe(r => {
      this.nodes = r;
      this.tree.treeModel.update();
    });
  }

  removeSelectedNode() {

    const nodeId = this.tree.treeModel.getActiveNode().id;
    const index = this.tree.treeModel.getActiveNode().index;
    let cnode: MyTreeNode = this.getMyTreeNodeById(nodeId);
    this.financeChargeCategoryService.deleteOne(cnode.categoryId).subscribe(r => {
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
    newRootNode.name = this.categoryName.value;
    newRootNode.isLevelOne = true;
    this.nodes.push(newRootNode);
    this.tree.treeModel.update();
  }

  enableWhenNodeIsActivated(): boolean {
    return this.tree.treeModel.getFocusedNode() != null;

  }

  onPreAddChildNodeButtonClicked() {
    this.nodeOperation = ChargeAdminListComponent.CREATE_SUB_NODE;
    this.editNodeModal.open();
  }

  onPreRootNodeButtonClicked() {
    this.nodeOperation = ChargeAdminListComponent.CREATE_HOME_NODE;
    this.editNodeModal.open();
  }

  onPreEditNodeButtonClicked() {

    this.nodeOperation = ChargeAdminListComponent.EDIT_NODE;

    const nodeId = this.tree.treeModel.getActiveNode().id;
    let node = this.getMyTreeNodeById(nodeId);
    this.categoryName.setValue(node.name);

    this.editNodeModal.open();
  }

  onAddSubNode() {

    const nodeId = this.tree.treeModel.getActiveNode().id;
    let parentNode = this.getMyTreeNodeById(nodeId);

    const newRootNode = new MyTreeNode();
    newRootNode.name = this.categoryName.value;
    newRootNode.isLevelOne = false;
    if (parentNode.children == null)
      parentNode.children = [];

    parentNode.children.push(newRootNode);
    this.tree.treeModel.update();

    this.tree.treeModel.getActiveNode().expand();

  }

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
    let node = this.getMyTreeNodeById(nodeId);

    this.financeChargeCategoryService.renameChargeCategory(node.categoryId, this.categoryName.value).subscribe(r => {
      this.loadData();

    });


  }

  onEditNodeModalModalClosed() {
    switch (this.nodeOperation) {
      case ChargeAdminListComponent.CREATE_HOME_NODE:
        this.financeChargeCategoryService.create({'name': this.categoryName.value}).subscribe(r => {
          this.loadData()
        });
        //this.onCreateRootNode();
        break;
      case ChargeAdminListComponent.CREATE_SUB_NODE:

        this.financeChargeCategoryService.create({'parentId':this.selectedCategoryId, 'name': this.categoryName.value}).subscribe(r => {
          this.loadData()
        });
        break;
      case ChargeAdminListComponent.EDIT_NODE:
        this.onEditNode();
        break;
      default: {

      }
    }
    this.categoryName.setValue("");
    this.nodeOperation = 0;
  }

  onConfirmDeleteModalClosed() {
    this.removeSelectedNode();

  }

  getSelectedNodeName() {
    if (this.tree.treeModel.getActiveNode() != null) {
      const nodeId = this.tree.treeModel.getActiveNode().id;
      let node = this.getMyTreeNodeById(nodeId);
      this.selectedNodeName = node.name;
      this.selectedCategoryId = node.categoryId;
    } else return "";
  }

  onPreRemoveNodeButtonClicked() {
    this.confirmDeleteModal.open();
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

}
