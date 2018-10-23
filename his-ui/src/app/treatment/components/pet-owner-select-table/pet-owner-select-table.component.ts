import {Component, OnInit} from '@angular/core';
import {AbstractItemSelectableTableComponent} from "../../../shared/components/abstract-item-selectable-table/abstract-item-selectable-table.component";
import {PetOwner} from "../../models/pet-owner.model";

@Component({
  selector: 'app-pet-owner-select-table',
  templateUrl: './pet-owner-select-table.component.html',
  styleUrls: ['./pet-owner-select-table.component.css']
})
export class PetOwnerSelectTableComponent extends AbstractItemSelectableTableComponent<PetOwner> implements OnInit {

  constructor() {
    super();
  }

  ngOnInit() {
  }

}
