import {EventEmitter, Input, OnInit, Output, ViewChild} from '@angular/core';
import {TreeComponent} from "angular-tree-component";
import {MyTreeNode} from "../../../core/models/my-tree-node.model";

export abstract class AbstractCategoryTreeComponent  {

  @Input()
  nodes: MyTreeNode[]=[];

  @Output()
  nodeSelected = new EventEmitter<MyTreeNode>();

  @ViewChild(TreeComponent)
  tree: TreeComponent;

  expandTree(){
    this.tree.treeModel.expandAll();
  }


  onNodeActivated(event) {
    this.getSelectedNodeName();
  }

  getSelectedNodeName() {
    const nodeId = this.tree.treeModel.getActiveNode().id;
    let node = this.getMyTreeNodeById(nodeId);
    let nodeInfo: MyTreeNode = new MyTreeNode();
    nodeInfo.name = node.name;
    nodeInfo.id = node.categoryId;
    this.nodeSelected.emit(nodeInfo);
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
