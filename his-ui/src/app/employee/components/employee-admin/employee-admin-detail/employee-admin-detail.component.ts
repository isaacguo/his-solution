import {Component, Input, OnChanges, OnInit, SimpleChanges, ViewChild} from '@angular/core';
import {Router} from "@angular/router";
import {ModalComponent} from "ng2-bs3-modal/ng2-bs3-modal";
import {TreeComponent} from "angular-tree-component";
import {MyTreeNode} from "../../../../core/models/my-tree-node.model";
import {EmployeeListItem} from "../../../models/employee-list-item.model";
import {Employee} from "../../../models/employee.model";
import {EmployeeDepartmentService} from "../../../../core/services/employee/employee-department.service";
import {EmployeeService} from "../../../../core/services/employee/employee.service";
import {TreeNodeService} from "../../../../core/services/common/tree-node.service";
import {OperationEnum} from "../../../../core/enums/operation.enum";

@Component({
  selector: 'app-employee-admin-detail',
  templateUrl: './employee-admin-detail.component.html',
  styleUrls: ['./employee-admin-detail.component.css']
})
export class EmployeeAdminDetailComponent implements OnInit, OnChanges {

  @ViewChild("setAsManagerResultModal")
  setAsManagerResultModal:ModalComponent;

  @ViewChild("adjustDepartmentModal")
  adjustDepartmentModal: ModalComponent;

  @ViewChild("confirmDeletionModal")
  confirmDeletionModal: ModalComponent;
  @Input()
  departmentId: number;

  @ViewChild(TreeComponent)
  tree: TreeComponent;
  @ViewChild("setAsManagerConfirmationModal")
  setAsManagerConfirmationModal: ModalComponent;


  @Input()
  nodes: MyTreeNode[];

  emplyeeList: EmployeeListItem[] = [];
  toBeDeletedEmployee: Employee;
  toBeMovedEmployee: Employee;

  managerUuid: string;
  manager: EmployeeListItem;

  constructor(private departmentService: EmployeeDepartmentService, private router: Router, private employeeService: EmployeeService, private treeNodeService: TreeNodeService) {
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
    this.router.navigate(['employee-profile', uuid]);
  }

  onEditButtonClicked(uuid: String) {
    this.router.navigate(['employee-operation', OperationEnum.UPDATE, uuid]);
  }

  onAddNewEmployeeButtonClicked() {
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

    this.manager=null;

    if (this.departmentId !== undefined) {
      this.departmentService.findManager(this.departmentId).subscribe(
        r => {
          this.managerUuid = r.uuid;

          this.employeeService.getEmployeeListByDepartmentId(this.departmentId).subscribe(r => {
            this.emplyeeList = r;

            if (this.emplyeeList.length > 0) {

              let index = r.findIndex(m => {
                return m.uuid === this.managerUuid;
              });

              if (index > -1) {
                this.manager = r.splice(index,1)[0];
              }
            }
          });
        }
      )
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
      this.setAsManagerResultModal.open();
    });
  }
}
