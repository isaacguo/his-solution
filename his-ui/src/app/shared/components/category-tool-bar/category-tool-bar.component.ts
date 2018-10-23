import {Component, EventEmitter, Input, OnInit, Output, ViewChild} from '@angular/core';
import {ModalComponent} from "ng2-bs3-modal/ng2-bs3-modal";
import {FormControl, Validators} from "@angular/forms";
import {MyTreeNode} from "../../../core/models/my-tree-node.model";

@Component({
  selector: 'app-category-tool-bar',
  templateUrl: './category-tool-bar.component.html',
  styleUrls: ['./category-tool-bar.component.css']
})
export class CategoryToolBarComponent implements OnInit {


  @Input()
  canDelete: boolean = true;
  @Input()
  canEdit: boolean = true;
  @Input()
  canCreateRootNode: boolean = true;
  @Input()
  canCreateChildNode: boolean = true;
  @Input()
  selectedNode: MyTreeNode;

  @Output()
  nodeDeleted = new EventEmitter<MyTreeNode>();
  @Output()
  nodeUpdated = new EventEmitter<MyTreeNode>();
  @Output()
  rootNodeCreated = new EventEmitter<MyTreeNode>();
  @Output()
  subNodeCreated = new EventEmitter<MyTreeNode>();
  @Output()
  nodeExpanded=new EventEmitter();
  @ViewChild("editNodeModal")
  editNodeModal: ModalComponent;
  @ViewChild("confirmDeleteModal")
  confirmDeleteModal: ModalComponent;
  nodeOperation: number;
  categoryName: FormControl = new FormControl('', [Validators.required, Validators.minLength(1)]);
  private CREATE_HOME_NODE: number = 1;
  private CREATE_SUB_NODE: number = 2;
  private EDIT_NODE: number = 3;

  constructor() {
  }

  ngOnInit() {
  }

  onAddChildNodeButtonClicked() {
    this.nodeOperation = this.CREATE_SUB_NODE;
    this.editNodeModal.open();
  }

  onEditNodeButtonClicked() {
    this.nodeOperation = this.EDIT_NODE;
    this.categoryName.setValue(this.selectedNode.name);
    this.editNodeModal.open();
  }

  onAddRootNodeButtonClicked() {
    this.nodeOperation = this.CREATE_HOME_NODE;
    this.editNodeModal.open();
  }

  onRemoveNodeButtonClicked() {
    this.confirmDeleteModal.open();
  }

  onConfirmDeleteModalClosed() {
    this.nodeDeleted.emit(this.selectedNode);
  }

  onEditNodeModalClosed() {
    switch (this.nodeOperation) {
      case this.CREATE_HOME_NODE:
        let rootNodeInfo: MyTreeNode = new MyTreeNode();
        rootNodeInfo.name = this.categoryName.value;
        this.rootNodeCreated.emit(rootNodeInfo);
        break;
      case this.CREATE_SUB_NODE:

        let subNodeInfo: MyTreeNode = new MyTreeNode();
        subNodeInfo.name = this.categoryName.value;
        subNodeInfo.id = this.selectedNode.id;
        this.subNodeCreated.emit(subNodeInfo);

        break;
      case this.EDIT_NODE:
        let editNodeInfo: MyTreeNode = new MyTreeNode();
        editNodeInfo.id = this.selectedNode.id;
        editNodeInfo.name = this.categoryName.value

        this.nodeUpdated.emit(editNodeInfo);
        break;
      default: {
      }
    }
    this.categoryName.setValue("");
    this.nodeOperation = 0;

  }

  onExpandNodeButtonClicked() {
    this.nodeExpanded.emit();
  }
}
