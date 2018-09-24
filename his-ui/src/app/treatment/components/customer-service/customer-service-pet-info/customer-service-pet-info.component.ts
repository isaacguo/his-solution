import {Component, Input, OnInit} from '@angular/core';
import {TreatmentCase} from "../../../models/treatment-case.model";
import {PetOwner} from "../../../models/pet-owner.model";
import {Pet} from "../../../models/pet.model";

@Component({
  selector: 'app-customer-service-pet-info',
  templateUrl: './customer-service-pet-info.component.html',
  styleUrls: ['./customer-service-pet-info.component.css']
})
export class CustomerServicePetInfoComponent implements OnInit {


  @Input()
  treatmentCase: TreatmentCase
  @Input()
  petOwner:PetOwner;


  constructor() {
  }

  ngOnInit() {
  }

}
