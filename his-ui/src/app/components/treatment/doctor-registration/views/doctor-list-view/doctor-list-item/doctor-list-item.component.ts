import {Component, Input, OnInit} from '@angular/core';
import {Doctor} from "../../../../../../dto/treatment/doctor.model";
import {DepartmentService} from "../../../../../../services/treatment/department.service";
import {BsModalComponent} from "ng2-bs3-modal";
import {TreatmentCase} from "../../../../../../dto/treatment/treatment-case.model";

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
