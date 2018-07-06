import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-medical-test-settings-report-template-category-detail',
  templateUrl: './medical-test-settings-report-template-category-detail.component.html',
  styleUrls: ['./medical-test-settings-report-template-category-detail.component.css']
})
export class MedicalTestSettingsReportTemplateCategoryDetailComponent implements OnInit {

  @Input()
  categoryName: string;
  @Input()
  categoryId: number;

  constructor() {
  }

  ngOnInit() {
  }

}
