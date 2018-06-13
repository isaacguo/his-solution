import {Component, Input, OnChanges, OnInit, SimpleChanges, ViewChild} from '@angular/core';
import {EmployeeListItem} from "../../../../dto/employee/employee-list-item.model";
import {EmployeeService} from "../../../../services/employee/employee.service";
import {Router} from "@angular/router";
import {OperationEnum} from "../../../../enums/operation.enum";
import {Employee} from "../../../../dto/employee/employee.model";
import {ModalComponent} from "ng2-bs3-modal/ng2-bs3-modal";
import {MyTreeNode} from "../../../../dto/procurement/MyTreeNode";
import {TreeComponent} from "angular-tree-component";
import {TreeNodeService} from "../../../../services/common/tree-node.service";

@Component({
  selector: 'app-employee-admin-detail',
  templateUrl: './employee-admin-detail.component.html',
  styleUrls: ['./employee-admin-detail.component.css']
})
export class EmployeeAdminDetailComponent implements OnInit, OnChanges {

  @ViewChild("adjustDepartmentModal")
  adjustDepartmentModal: ModalComponent;

  @ViewChild("confirmDeletionModal")
  confirmDeletionModal: ModalComponent;
  @Input()
  departmentId: number;

  @ViewChild(TreeComponent)
  tree: TreeComponent;
  @ViewChild("setAsManagerConfirmationModal")
  setAsManagerConfirmationModal:ModalComponent;


  @Input()
  nodes: MyTreeNode[];

  emplyeeList: EmployeeListItem[] = [];
  toBeDeletedEmployee: Employee;
  toBeMovedEmployee: Employee;

  constructor(private router: Router, private employeeService: EmployeeService, private treeNodeService: TreeNodeService) {
  }

  onConfirmDeletionModalClosed() {
    this.employeeService.deleteEmployee(this.toBeDeletedEmployee.id).subscribe(r => {
      this.loadData();
    });
  }

  ngOnChanges(changes: SimpleChanges): void {

    this.loadData();
  }

  ngOnInit() {
  }

  onViewButtonClicked(uuid: String) {
    console.log(uuid);
    this.router.navigate(['employee-profile', uuid]);
  }

  onEditButtonClicked(uuid: String) {
    console.log(uuid);
    this.router.navigate(['employee-operation', OperationEnum.UPDATE, uuid]);
  }

  onAddNewEmployeeButtonClicked() {
    console.log(this.departmentId);
    this.router.navigate(['employee-operation', OperationEnum.CREATE, this.departmentId]);
  }

  onRemoveButtonClicked(employee: Employee) {
    this.toBeDeletedEmployee = employee;
    this.confirmDeletionModal.open();
  }

  onAdjustDepartment(employee: Employee) {

    this.tree.treeModel.update();
    this.tree.treeModel.expandAll();

    this.toBeMovedEmployee = employee;

    this.adjustDepartmentModal.open();
  }

  onAdjustDepartmentModalClosed() {
    this.employeeService.moveEmployeeToDepartment(this.toBeMovedEmployee.id, this.selectedDepartmentId).subscribe(r => {
      this.loadData();
    });

  }

  private loadData() {
    if (this.departmentId !== undefined) {
      this.employeeService.getEmployeeListByDepartmentId(this.departmentId).subscribe(r => {
        this.emplyeeList = r;
      });
    }
  }

  selectedNodeName: string;
  selectedDepartmentId: string;

  getSelectedNodeName() {
    if (this.tree.treeModel.getActiveNode() != null) {
      const nodeId = this.tree.treeModel.getActiveNode().id;
      let node = this.treeNodeService.getMyTreeNodeById(this.nodes, nodeId);
      this.selectedNodeName = node.name;
      this.selectedDepartmentId = node.categoryId;
    } else return "";
  }

  onNodeActivated($event) {
    this.getSelectedNodeName();
  }

  toBeManager: Employee;

  onSetAsManager(employee: Employee) {
    this.toBeManager = employee;
    this.setAsManagerConfirmationModal.open();

  }

  onSetAsManagerConfirmationModalClosed() {
    this.employeeService.setAsManager(this.toBeManager.id).subscribe(r => {
      this.loadData();
    });
  }
}
