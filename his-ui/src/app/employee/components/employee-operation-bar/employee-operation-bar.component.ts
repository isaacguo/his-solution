import {ChangeDetectionStrategy, Component, EventEmitter, Input, OnInit, Output, ViewChild} from '@angular/core';
import {EmployeeListItem} from "../../../core/models/employee/employee-list-item.model";
import {ModalComponent} from "ng2-bs3-modal/ng2-bs3-modal";
import {TreeComponent} from "angular-tree-component";
import {MyTreeNode} from "../../../core/models/my-tree-node.model";

@Component({
  selector: 'app-employee-operation-bar',
  templateUrl: './employee-operation-bar.component.html',
  styleUrls: ['./employee-operation-bar.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush

})
export class EmployeeOperationBarComponent implements OnInit {


  @ViewChild("adjustDepartmentModal")
  adjustDepartmentModal: ModalComponent;

  @ViewChild("confirmDeletionModal")
  confirmDeletionModal: ModalComponent;

  @ViewChild("setAsManagerConfirmationModal")
  setAsManagerConfirmationModal: ModalComponent;

  @ViewChild(TreeComponent)
  tree: TreeComponent;


  @Input()
  employee: EmployeeListItem;
  @Input()
  manager: EmployeeListItem;
  @Input()
  noTeamMembers: boolean;

  @Input()
  nodes: MyTreeNode[];
  @Output()
  employeeViewed = new EventEmitter<EmployeeListItem>();
  @Output()
  employeeEdited = new EventEmitter<EmployeeListItem>();
  @Output()
  employeeRemoved = new EventEmitter<EmployeeListItem>();
  @Output()
  employeeDepartmentAdjusted = new EventEmitter<any>();
  @Output()
  employeeManagerSet = new EventEmitter<EmployeeListItem>();
  selectedNodeInfo: MyTreeNode;

  constructor() {


  }

  ngOnInit() {

  }

  onViewButtonClicked() {
    this.employeeViewed.emit(this.employee?this.employee:this.manager);
  }

  onEditButtonClicked() {
    this.employeeEdited.emit(this.employee?this.employee:this.manager);
  }

  onRemoveButtonClicked(employee: EmployeeListItem) {
    this.confirmDeletionModal.open();
  }

  onAdjustDepartment(employee: EmployeeListItem) {
    this.tree.treeModel.expandAll();
    this.adjustDepartmentModal.open();
  }

  onSetAsManager() {
    this.setAsManagerConfirmationModal.open();
  }

  onSetAsManagerConfirmationModalClosed() {
    this.employeeManagerSet.emit(this.employee);
  }

  onAdjustDepartmentModalClosed() {
    this.employeeDepartmentAdjusted.emit({
      id: this.employee ? this.employee.id : this.manager.id,
      departmentId: this.selectedNodeInfo.id
    });
  }

  onConfirmDeletionModalClosed() {
    this.employeeRemoved.emit(this.employee ? this.employee : this.manager);
  }

  onNodeActivated(event) {
    const nodeId = this.tree.treeModel.getActiveNode().id;
    let node = this.getMyTreeNodeById(nodeId);
    this.selectedNodeInfo = new MyTreeNode();
    this.selectedNodeInfo.name = node.name;
    this.selectedNodeInfo.id = node.categoryId;
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
