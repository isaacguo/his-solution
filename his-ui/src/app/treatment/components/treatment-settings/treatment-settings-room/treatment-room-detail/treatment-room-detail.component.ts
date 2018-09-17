import {Component, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {Department} from "../../../../models/department.model";
import {DepartmentService} from "../../../../services/department.service";

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
