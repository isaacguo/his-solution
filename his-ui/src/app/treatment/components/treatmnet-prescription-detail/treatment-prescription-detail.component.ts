import {Component, OnInit} from '@angular/core';
import {AbstractItemSelectableTableComponent} from "../../../shared/components/abstract-item-selectable-table/abstract-item-selectable-table.component";

@Component({
  selector: 'app-treatment-prescription-detail',
  templateUrl: './treatment-prescription-detail.component.html',
  styleUrls: ['./treatment-prescription-detail.component.css']
})
export class TreatmentPrescriptionDetailComponent extends AbstractItemSelectableTableComponent<any> implements OnInit {

  constructor() {
     super();
  }

  ngOnInit() {
  }

}
