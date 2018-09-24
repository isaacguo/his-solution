import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {Observable} from "rxjs/Observable";
import {TreatmentCaseService} from "../../../core/services/treatment/treatment-case.service";
import {TreatmentCase} from "../../models/treatment-case.model";

@Component({
  selector: 'app-customer-service-container',
  templateUrl: './customer-service-container.component.html',
  styleUrls: ['./customer-service-container.component.css']
})
export class CustomerServiceContainerComponent implements OnInit {

  filteredTreatmentCases: Observable<TreatmentCase[]>;

  constructor(private router: Router,
              private treatmentCaseService: TreatmentCaseService) {


    //filteredTreatmentCases should get items bases on searching criteria. for now, use service to get items directly
    this.filteredTreatmentCases=this.treatmentCaseService.getItems();


  }

  ngOnInit() {
    this.treatmentCaseService.loadData();
  }


  onSearchCriteriaCreated(event) {


  }

  onItemSelected(event) {
    this.router.navigate(['treatment','customer-service','treatment-case', event]);
  }
}
