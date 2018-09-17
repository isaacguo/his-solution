import {Component, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {MedicalTestDepartmentService} from "../../../../services/medical-test-department.service";

@Component({
  selector: 'app-medical-test-settings-department-detail',
  templateUrl: './medical-test-settings-department-detail.component.html',
  styleUrls: ['./medical-test-settings-department-detail.component.css']
})
export class MedicalTestSettingsDepartmentDetailComponent implements OnChanges {

  @Input()
  departmentId: number;
  @Input()
  departmentName: string;

  department: any={};


  ngOnChanges(changes: SimpleChanges): void {
    this.loadData();
  }

  constructor(private medicalTestDepartmentService: MedicalTestDepartmentService) {

  }

  loadData() {
    if (this.departmentId != undefined)
      this.medicalTestDepartmentService.getDepartmentByDepId(this.departmentId).subscribe(r => {
        this.department = r;
      });
  }

  onMedicalTestRoomSwitchChanged(event: boolean) {

    this.medicalTestDepartmentService.setDepartmentEnable(this.departmentId,this.departmentName,event).subscribe(r=>{
      this.loadData();
    })
  }
}
