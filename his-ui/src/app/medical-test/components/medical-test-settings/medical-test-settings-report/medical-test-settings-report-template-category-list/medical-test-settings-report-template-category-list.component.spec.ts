import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {MedicalTestSettingsReportTemplateCategoryListComponent} from './medical-test-settings-report-template-category-list.component';

describe('MedicalTestSettingsReportTemplateCategoryListComponent', () => {
  let component: MedicalTestSettingsReportTemplateCategoryListComponent;
  let fixture: ComponentFixture<MedicalTestSettingsReportTemplateCategoryListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MedicalTestSettingsReportTemplateCategoryListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MedicalTestSettingsReportTemplateCategoryListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
