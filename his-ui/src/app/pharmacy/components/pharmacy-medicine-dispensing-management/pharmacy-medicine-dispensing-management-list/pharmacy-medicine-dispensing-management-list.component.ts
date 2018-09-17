import {Component, OnInit} from '@angular/core';
import {PharmacyMedicineService} from "../../../services/pharmacy-medicine.service";

@Component({
  selector: 'app-pharmacy-medicine-dispensing-management-list',
  templateUrl: './pharmacy-medicine-dispensing-management-list.component.html',
  styleUrls: ['./pharmacy-medicine-dispensing-management-list.component.css']
})
export class PharmacyMedicineDispensingManagementListComponent implements OnInit {


  constructor(private pharmacyMedicineService: PharmacyMedicineService) {
  }

  ngOnInit() {
    this.loadData();
  }

  list: any[] = [];

  loadData() {
    this.pharmacyMedicineService.readAll().subscribe(r => {
      this.list = r;
    })
  }


  onRowClicked(item:any)
  {

  }
  isRowSelected(item:any)
  {

  }
}
