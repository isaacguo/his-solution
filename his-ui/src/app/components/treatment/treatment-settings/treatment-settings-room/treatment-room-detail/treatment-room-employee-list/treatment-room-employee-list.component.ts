import {Component, Input, OnInit} from '@angular/core';
import {EmployeeService} from "../../../../../../services/employee/employee.service";
import {EmployeeListItem} from "../../../../../../dto/employee/employee-list-item.model";
import {Employee} from "../../../../../../dto/employee/employee.model";

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
