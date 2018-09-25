import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {MedicalTestSettingsReportTemplateCategoryDetailComponent} from './medical-test-settings-report-template-category-detail.component';

describe('MedicalTestSettingsReportTemplateCategoryDetailComponent', () => {
  let component: MedicalTestSettingsReportTemplateCategoryDetailComponent;
  let fixture: ComponentFixture<MedicalTestSettingsReportTemplateCategoryDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MedicalTestSettingsReportTemplateCategoryDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MedicalTestSettingsReportTemplateCategoryDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
