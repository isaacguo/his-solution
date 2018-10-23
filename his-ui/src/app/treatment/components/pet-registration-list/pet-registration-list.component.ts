import {Component, OnInit} from '@angular/core';
import {AbstractItemSelectableTableComponent} from "../../../shared/components/abstract-item-selectable-table/abstract-item-selectable-table.component";
import {RegistrationStatusEnum} from "../../../core/enums/registration-status.enum";
import {TreatmentRegistrationModel} from "../../models/treatment.registration.model";

@Component({
  selector: 'app-pet-registration-list',
  templateUrl: './pet-registration-list.component.html',
  styleUrls: ['./pet-registration-list.component.css']
})
export class PetRegistrationListComponent extends AbstractItemSelectableTableComponent<TreatmentRegistrationModel> implements OnInit {

  constructor() {
    super();
  }

  ngOnInit() {
  }

  getRegistrationStatusString(reg: RegistrationStatusEnum): string {
    return RegistrationStatusEnum[reg];

  }
}
