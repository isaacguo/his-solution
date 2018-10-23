import {Component, OnInit} from '@angular/core';
import {MyTreeNode} from "../../../core/models/my-tree-node.model";
import {BehaviorSubject} from "rxjs/BehaviorSubject";
import {Observable} from "rxjs/Observable";

@Component({
  selector: 'app-inventory-query-container',
  templateUrl: './inventory-query-container.component.html',
  styleUrls: ['./inventory-query-container.component.css']
})
export class InventoryQueryContainerComponent implements OnInit {


  constructor() {
  }

  ngOnInit() {

  }

  nodesSubject = new BehaviorSubject<MyTreeNode[]>([]);
  selectedNodeSubject = new BehaviorSubject<MyTreeNode | null>(null);
  getSelectedNode(): Observable<MyTreeNode> {
    return this.selectedNodeSubject.asObservable();
  }
  getNodes(): Observable<MyTreeNode[]> {
    return this.nodesSubject.asObservable();
  }
  onNodeCreated(event: MyTreeNode) {

  }
  onNodeDeleted(event: MyTreeNode) {

  }
  onNodeUpdated(event: MyTreeNode) {

  }

  onNodeSelected(event)
  {

  }


}
