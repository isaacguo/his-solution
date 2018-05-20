import {Component, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {DepartmentListItem} from "../../../../../dto/employee/department-list-item.model";
import {DepartmentService} from "../../../../../services/treatment/department.service";
import {Department} from "../../../../../dto/treatment/department.model";
import {EmployeeService} from "../../../../../services/employee/employee.service";
import {EmployeeListItem} from "../../../../../dto/employee/employee-list-item.model";
import {Employee} from "../../../../../dto/employee/employee.model";

@Component({
  selector: 'app-treatment-room-detail',
  templateUrl: './treatment-room-detail.component.html',
  styleUrls: ['./treatment-room-detail.component.css']
})
export class TreatmentRoomDetailComponent implements OnChanges {

  @Input()
  departmentId: number;
  @Input()
  departmentName: string;

  department: Department;


  ngOnChanges(changes: SimpleChanges): void {
    this.loadData();
  }

  constructor(private departmentService: DepartmentService) {

  }

  loadData() {
    if (this.departmentId != undefined)
      this.departmentService.getDepartmentByDepId(this.departmentId).subscribe(r => {
        this.department = r;
      });

  }

  onOpenToFrontDesk(event: boolean) {

    this.departmentService.setDepartmentOpenToFrontDeskValue(this.departmentId, this.departmentName, event).subscribe(r => {
      this.loadData();
    });
  }


}
