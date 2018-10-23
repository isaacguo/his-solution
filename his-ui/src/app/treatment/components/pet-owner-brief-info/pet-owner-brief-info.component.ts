import {Component, Input, OnInit} from '@angular/core';
import {PetOwner} from "../../models/pet-owner.model";

@Component({
  selector: 'app-pet-owner-brief-info',
  templateUrl: './pet-owner-brief-info.component.html',
  styleUrls: ['./pet-owner-brief-info.component.css']
})
export class PetOwnerBriefInfoComponent implements OnInit {
  @Input()
  petOwner:PetOwner;

  constructor() { }

  ngOnInit() {
  }


  onCreateNewOwnerButtonClicked()
  {

  }
  onModifyOwnerButtonClicked()
  {

  }
  onClearPetButtonClicked(){}
}
