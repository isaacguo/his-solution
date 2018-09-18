import {Component, OnInit, ViewChild} from '@angular/core';
import {TreeComponent} from "angular-tree-component";
import {FormControl, Validators} from "@angular/forms";
import {ModalComponent} from "ng2-bs3-modal/ng2-bs3-modal";
import {DepartmentListItem} from "../../../../../employee/models/department-list-item.model";
import {MyTreeNode} from "../../../../../core/models/my-tree-node.model";
import {VendorCategoryService} from "../../../../services/vendor-category.service";
import {EmployeeDepartmentService} from "../../../../../core/services/employee-department.service";

@Component({
  selector: 'app-category-list',
  templateUrl: './category-list.component.html',
  styleUrls: ['./category-list.component.css']
})
export class CategoryListComponent implements OnInit {


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

  constructor(private vendorCategoryService: VendorCategoryService,
              private employeeDepartmentService: EmployeeDepartmentService) {


  }

  ngOnInit() {
    this.loadData();
    this.employeeDepartmentService.getDepartmentList().subscribe(r => {
      this.departmentList = r;
    });
  }

  private loadData() {
    this.vendorCategoryService.findAllForList().subscribe(r => {
      this.nodes = r;
      this.tree.treeModel.update();
    });
  }

  removeSelectedNode() {

    const nodeId = this.tree.treeModel.getActiveNode().id;
    const index = this.tree.treeModel.getActiveNode().index;
    let cnode: MyTreeNode = this.getMyTreeNodeById(nodeId);
    this.vendorCategoryService.deleteVendorCategory(cnode.categoryId).subscribe(r => {
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
    this.nodeOperation = CategoryListComponent.CREATE_SUB_NODE;
    this.editNodeModal.open();
  }

  onPreRootNodeButtonClicked() {
    this.nodeOperation = CategoryListComponent.CREATE_HOME_NODE;
    this.editNodeModal.open();
  }

  onPreEditNodeButtonClicked() {

    this.nodeOperation = CategoryListComponent.EDIT_NODE;

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

    this.vendorCategoryService.updateVendorCategoryName(node.categoryId, this.categoryName.value).subscribe(r => {
      this.loadData();

    });


  }

  onEditNodeModalModalClosed() {
    switch (this.nodeOperation) {
      case CategoryListComponent.CREATE_HOME_NODE:
        this.vendorCategoryService.createVendorCategory(this.categoryName.value).subscribe(r => {
          this.loadData()
        });
        //this.onCreateRootNode();
        break;
      case CategoryListComponent.CREATE_SUB_NODE:
        this.onAddSubNode();
        break;
      case CategoryListComponent.EDIT_NODE:
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
