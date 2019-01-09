import {Component, Input, OnInit} from '@angular/core';
import {MedicineInfo} from "../../models/medicine-info.model";
import {Pet} from "../../../treatment/models/pet.model";
import {PetOwner} from "../../../treatment/models/pet-owner.model";

@Component({
  selector: 'app-basic-info',
  templateUrl: './basic-info.component.html',
  styleUrls: ['./basic-info.component.css']
})
export class BasicInfoComponent implements OnInit {

  @Input()
  prescription: any;

  @Input()
  pet: Pet;


  constructor() {
  }

  ngOnInit() {
  }

}
