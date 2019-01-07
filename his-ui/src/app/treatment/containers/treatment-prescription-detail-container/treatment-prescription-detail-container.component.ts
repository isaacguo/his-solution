import { Component, OnInit } from '@angular/core';
import {Observable} from "rxjs";

@Component({
  selector: 'app-treatment-prescription-detail-container',
  templateUrl: './treatment-prescription-detail-container.component.html',
  styleUrls: ['./treatment-prescription-detail-container.component.css']
})
export class TreatmentPrescriptionDetailContainerComponent implements OnInit {

  prescriptions:Observable<any[]>;

  constructor() { }

  ngOnInit() {
  }

  onMedicineSelected($event: any) {

  }
}
