import {Component, OnInit} from '@angular/core';
import {Observable} from "rxjs/Observable";
import {Medicine} from "../../models/medicine.model";
import {MedicineInfo} from "../../models/medicine-info.model";

@Component({
  selector: 'app-dispensing-detail-container',
  templateUrl: './dispensing-detail-container.component.html',
  styleUrls: ['./dispensing-detail-container.component.css']
})
export class DispensingDetailContainerComponent implements OnInit {

  medicineInfo: Observable<MedicineInfo>;

  constructor() {
  }

  ngOnInit() {
  }

  onMedicineDispensed() {

  }
}
