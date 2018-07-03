import {Component, OnInit, ViewChild} from '@angular/core';
import {TreeComponent} from "angular-tree-component";
import {ModalComponent} from "ng2-bs3-modal/ng2-bs3-modal";
import {MyTreeNode} from "../../../../dto/procurement/MyTreeNode";
import {TreeviewOperationEnum} from "../../../../enums/treeview-operation.enum";
import {TreeNodeService} from "../../../../services/common/tree-node.service";
import {FormControl} from "@angular/forms";
import {FinanceChargeCategoryService} from "../../../../services/finance/finance-charge-category.service";

@Component({
  selector: 'app-charge-admin-list',
  templateUrl: './charge-admin-list.component.html',
  styleUrls: ['./charge-admin-list.component.css']
})
export class ChargeAdminListComponent implements OnInit {


  nodeOperation: TreeviewOperationEnum;

  nodes: MyTreeNode[] = [];

  chargeCategoryName: FormControl = new FormControl('');

  @ViewChild("editNodeModal")
  editNodeModal: ModalComponent;

  @ViewChild(TreeComponent)
  tree: TreeComponent;

  @ViewChild("confirmDeleteModal")
  confirmDeleteModal: ModalComponent;
  selectedNodeName: string;
  selectedChargeCategoryId: number;

  constructor(private financeChargeCategoryService:FinanceChargeCategoryService, private treeNodeService: TreeNodeService) {
  }

  ngOnInit() {
    this.loadData();
  }

  private loadData() {
    this.financeChargeCategoryService.getRootChargeCategory().subscribe(r => {
      this.nodes = r;
      this.tree.treeModel.update();
      this.tree.treeModel.expandAll();
    });
  }

  removeSelectedNode() {

    const nodeId = this.tree.treeModel.getActiveNode().id;
    const index = this.tree.treeModel.getActiveNode().index;
    let cnode: MyTreeNode = this.treeNodeService.getMyTreeNodeById(this.nodes, nodeId);
    this.financeChargeCategoryService.deleteOne(cnode.categoryId).subscribe(r => {
      this.loadData()
    });
  }

  onCreateRootNode() {
    const newRootNode = new MyTreeNode();
    newRootNode.name = this.chargeCategoryName.value;
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
    this.chargeCategoryName.setValue(node.name);

    this.editNodeModal.open();
  }

  /*
  onAddSubNode() {

    const nodeId = this.tree.treeModel.getActiveNode().id;
    let parentNode = this.getMyTreeNodeById(nodeId);

    const newRootNode = new MyTreeNode();
    newRootNode.name = this.chargeCategoryName.value;
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

    this.financeChargeCategoryService.renameChargeCategory(node.categoryId, this.chargeCategoryName.value).subscribe(r => {
      this.loadData();
    });

  }

  onEditNodeModalModalClosed() {
    switch (this.nodeOperation) {
      //case TreeviewOperationEnum.CREATE_HOME_NODE:

      //this.onCreateRootNode();
      // break;
      case TreeviewOperationEnum.CREATE_SUB_NODE:
        this.financeChargeCategoryService.create({'parentId': this.selectedChargeCategoryId, 'name': this.chargeCategoryName.value}).subscribe(r => {
          this.loadData()
        });
        break;
      case TreeviewOperationEnum.EDIT_NODE:
        this.onEditNode();
        break;
      default: {

      }
    }
    this.chargeCategoryName.setValue("");
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
      this.selectedChargeCategoryId = node.categoryId;
    } else return "";
  }

  onPreRemoveNodeButtonClicked() {
    this.confirmDeleteModal.open();
  }

}
