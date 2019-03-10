import { Component, OnInit } from '@angular/core';
import {Observable} from "rxjs/Observable";
import {Router} from "@angular/router";
import {TreatmentCaseService} from "../../../core/services/treatment/treatment-case.service";

@Component({
  selector: 'app-customer-service-container',
  templateUrl: './customer-service-container.component.html',
  styleUrls: ['./customer-service-container.component.css']
})
export class CustomerServiceContainerComponent implements OnInit {

  filteredTreatmentCases$: Observable<any[]>;

  constructor(private router: Router,
              private treatmentCaseService: TreatmentCaseService) {

    //filteredTreatmentCases should get items bases on searching criteria. for now, use service to get items directly

  }

  ngOnInit() {
    this.filteredTreatmentCases$=this.treatmentCaseService.readAll()
  }


  onSearchCriteriaCreated(event) {


  }

  onItemSelected(event) {
    this.router.navigate(['treatment','customer-service','treatment-case', event]);
  }

}
