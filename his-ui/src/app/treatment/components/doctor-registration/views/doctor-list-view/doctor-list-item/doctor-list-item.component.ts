import {Component, Input, OnInit} from '@angular/core';
import {BsModalComponent} from "ng2-bs3-modal";
import {Doctor} from "../../../../../models/doctor.model";
import {DepartmentService} from "../../../../../../core/services/treatment/department.service";
import {TreatmentCase} from "../../../../../models/treatment-case.model";

@Component({
  selector: 'doctor-list-item',
  templateUrl: './doctor-list-item.component.html',
  styleUrls: ['./doctor-list-item.component.css']
})
export class DoctorListItemComponent implements OnInit {

  @Input()
  doctor: Doctor;
  @Input()
  departmentUuid: string;

  constructor(private departmentService: DepartmentService) {
  }

  ngOnInit() {
  }

  onBookButtonClicked(modal: BsModalComponent) {
    modal.open();
  }

  onConfirmationModalClosed() {

    let treatmentCase: TreatmentCase = {};
    treatmentCase.doctor = this.doctor;
    treatmentCase.department = {};
    treatmentCase.department.uuid = this.departmentUuid;
    /*
    this.departmentService.createTreatmentCase(treatmentCase).subscribe(r => {
      console.log(r.createResult);
    });
    */
  }
}
