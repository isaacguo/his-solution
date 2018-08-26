import { Component, OnInit } from '@angular/core';
import {AbstractCategoryListComponent} from "../../../common/abstract-category-list/abstract-category-list.component";
import {PharmacyMedicineService} from "../../../../services/pharmacy/pharmacy-medicine.service";

@Component({
  selector: 'app-pharmacy-medicine-dispensing-management-list',
  templateUrl: './pharmacy-medicine-dispensing-management-list.component.html',
  styleUrls: ['./pharmacy-medicine-dispensing-management-list.component.css']
})
export class PharmacyMedicineDispensingManagementListComponent implements OnInit {


  constructor(private pharmacyMedicineService:PharmacyMedicineService) { }

  ngOnInit() {
  }

}
