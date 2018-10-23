import {Component, Input, OnInit} from '@angular/core';
import {MedicineInfo} from "../../models/medicine-info.model";

@Component({
  selector: 'app-basic-info',
  templateUrl: './basic-info.component.html',
  styleUrls: ['./basic-info.component.css']
})
export class BasicInfoComponent implements OnInit {

  @Input()
  medicineInfo:MedicineInfo;

  constructor() { }

  ngOnInit() {
  }

}
