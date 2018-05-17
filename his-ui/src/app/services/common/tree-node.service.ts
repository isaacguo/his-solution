import { Injectable } from '@angular/core';
import {MyTreeNode} from "../../dto/procurement/MyTreeNode";

@Injectable()
export class TreeNodeService {

  constructor() { }

  treeConverter(json: any, isLevelOne: boolean): MyTreeNode {

    let node = new MyTreeNode();
    node.name = json.name;
    node.categoryId = json.id;
    node.isLevelOne = isLevelOne;

    if (json.children != null && json.children.length > 0) {
      node.children = [];
      for (let child of json.children) {
        node.children.push(this.treeConverter(child, false));
      }
    }
    return node;
  }
}
