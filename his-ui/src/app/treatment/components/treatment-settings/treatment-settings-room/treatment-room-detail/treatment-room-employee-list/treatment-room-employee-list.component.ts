import {Component, Input, OnInit} from '@angular/core';
import {EmployeeListItem} from "../../../../../../employee/models/employee-list-item.model";
import {Employee} from "../../../../../../employee/models/employee.model";
import {EmployeeService} from "../../../../../../core/services/employee/employee.service";

@Component({
  selector: 'app-treatment-room-employee-list',
  templateUrl: './treatment-room-employee-list.component.html',
  styleUrls: ['./treatment-room-employee-list.component.css']
})
export class TreatmentRoomEmployeeListComponent implements OnInit {

  employeeList: EmployeeListItem[] = [];
  selectedEmployee: Employee;
  @Input()
  departmentId: number;

  constructor(private employeeService: EmployeeService) {


  }

  loadData() {
    if (this.departmentId !== undefined) {
      this.employeeService.getEmployeeListByDepartmentId(this.departmentId).subscribe(r => {
        this.employeeList = r;
      });
    }
  }

  onRowClicked(employee: Employee) {
    this.selectedEmployee = employee;
  }

  isRowSelected(employee: Employee) {
    return this.selectedEmployee == employee;
  }

  ngOnInit() {
    this.loadData();
  }

}
