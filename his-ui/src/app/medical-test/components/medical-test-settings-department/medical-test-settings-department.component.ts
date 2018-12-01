import {Component, OnInit} from '@angular/core';
import {AbstractCategoryTreeComponent} from "../../../shared/components/abstract-category-tree/abstract-category-tree.component";

@Component({
  selector: 'app-medical-test-settings-department',
  templateUrl: './medical-test-settings-department.component.html',
  styleUrls: ['./medical-test-settings-department.component.css']
})
export class MedicalTestSettingsDepartmentComponent extends AbstractCategoryTreeComponent implements OnInit {

  constructor() {
    super();
  }

  ngOnInit() {
  }

}
