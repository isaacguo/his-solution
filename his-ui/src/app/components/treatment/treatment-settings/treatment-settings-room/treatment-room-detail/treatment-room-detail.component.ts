import {Component, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {DepartmentListItem} from "../../../../../dto/employee/department-list-item.model";
import {DepartmentService} from "../../../../../services/treatment/department.service";
import {Department} from "../../../../../dto/treatment/department.model";

@Component({
  selector: 'app-treatment-room-detail',
  templateUrl: './treatment-room-detail.component.html',
  styleUrls: ['./treatment-room-detail.component.css']
})
export class TreatmentRoomDetailComponent implements OnChanges {

  @Input()
  departmentId: string;

  department: Department;


  ngOnChanges(changes: SimpleChanges): void {
    this.loadData();
  }

  constructor(private departmentService: DepartmentService) {

  }

  loadData() {
    this.departmentService.getDepartmentByUuid(this.departmentId).subscribe(r => {
      this.department=r;
    });
  }


  onChange(dep: DepartmentListItem, event) {
    /*
    this.isModified = true;
    let department = this.vendorCategory.departments.find(r => r.departmentId === dep.id);
    if (department != null)
      department.permitted = event;
      */
  }

}
