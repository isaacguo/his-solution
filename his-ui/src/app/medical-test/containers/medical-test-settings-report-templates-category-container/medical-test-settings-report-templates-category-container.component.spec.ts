import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MedicalTestSettingsReportTemplatesCategoryContainerComponent } from './medical-test-settings-report-templates-category-container.component';

describe('MedicalTestSettingsReportTemplatesCategoryContainerComponent', () => {
  let component: MedicalTestSettingsReportTemplatesCategoryContainerComponent;
  let fixture: ComponentFixture<MedicalTestSettingsReportTemplatesCategoryContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MedicalTestSettingsReportTemplatesCategoryContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MedicalTestSettingsReportTemplatesCategoryContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
