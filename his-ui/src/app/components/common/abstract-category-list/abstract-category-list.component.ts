import {Input, OnInit, ViewChild} from '@angular/core';
import {MyTreeNode} from "../../../dto/procurement/MyTreeNode";
import {ModalComponent} from "ng2-bs3-modal/ng2-bs3-modal";
import {TreeComponent} from "angular-tree-component";
import {FormControl, Validators} from "@angular/forms";
import {CategoryService} from "./category-service";

export abstract class AbstractCategoryListComponent implements OnInit {

  @Input()
  showToolBox: boolean = true;

  private CREATE_HOME_NODE: number = 1;
  private CREATE_SUB_NODE: number = 2;
  private EDIT_NODE: number = 3;

  nodeOperation: number;

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

  constructor(protected categoryService: CategoryService) {

  }

  ngOnInit() {
    this.loadData();
  }

  private loadData() {
    this.categoryService.getNodes().subscribe(r => {
      this.nodes = r;
      this.tree.treeModel.update();
    });
  }

  removeSelectedNode() {

    const nodeId = this.tree.treeModel.getActiveNode().id;
    const index = this.tree.treeModel.getActiveNode().index;
    let cnode: MyTreeNode = this.getMyTreeNodeById(nodeId);
    this.categoryService.deleteOne(cnode.categoryId).subscribe(r => {
      this.loadData()
    });

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
    this.nodeOperation = this.CREATE_SUB_NODE;
    this.editNodeModal.open();
  }

  onPreRootNodeButtonClicked() {
    this.nodeOperation = this.CREATE_HOME_NODE;
    this.editNodeModal.open();
  }

  onPreEditNodeButtonClicked() {

    this.nodeOperation = this.EDIT_NODE;

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

    this.categoryService.update(node.categoryId, {
      "id": node.categoryId,
      "name": this.categoryName.value
    }).subscribe(r => {
      this.loadData();

    });


  }

  onEditNodeModalModalClosed() {
    switch (this.nodeOperation) {
      case this.CREATE_HOME_NODE:
        this.categoryService.create({'name': this.categoryName.value}).subscribe(r => {
          this.loadData()
        });
        //this.onCreateRootNode();
        break;
      case this.CREATE_SUB_NODE:

        this.categoryService.create({
          'parentId': this.selectedCategoryId,
          'name': this.categoryName.value
        }).subscribe(r => {
          this.loadData()
        });
        break;
      case this.EDIT_NODE:
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
