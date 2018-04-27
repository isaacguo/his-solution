import {Component, Input, OnChanges, OnInit, SimpleChanges, ViewChild} from '@angular/core';
import {EmployeeListItem} from "../../../../dto/employee/employee-list-item.model";
import {EmployeeService} from "../../../../services/employee/employee.service";
import {Router} from "@angular/router";
import {OperationEnum} from "../../../../enums/operation.enum";
import {Employee} from "../../../../dto/employee.model";
import {ModalComponent} from "ng2-bs3-modal/ng2-bs3-modal";

@Component({
  selector: 'app-employee-admin-detail',
  templateUrl: './employee-admin-detail.component.html',
  styleUrls: ['./employee-admin-detail.component.css']
})
export class EmployeeAdminDetailComponent implements OnInit, OnChanges {


  @ViewChild("confirmDeletionModal")
  confirmDeletionModal: ModalComponent;

  onConfirmDeletionModalClosed() {
    this.employeeService.deleteEmployee(this.toBeDeletedEmployee.id).subscribe(r => {
      this.loadData();
    });
  }

  ngOnChanges(changes: SimpleChanges): void {

    this.loadData();
  }

  @Input()
  departmentId: number;

  emplyeeList: EmployeeListItem[] = [];


  constructor(private router: Router, private employeeService: EmployeeService) {
  }

  ngOnInit() {
  }

  private loadData() {
    if (this.departmentId !== undefined) {
      this.employeeService.getEmployeeListByDepartmentId(this.departmentId).subscribe(r => {
        this.emplyeeList = r;
      });
    }
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

  toBeDeletedEmployee: Employee;

  onRemoveButtonClicked(employee: Employee) {
    console.log(employee);
    this.toBeDeletedEmployee = employee;
    this.confirmDeletionModal.open();
  }
}
