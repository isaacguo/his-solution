import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MedicalTestSettingsReportTemplatesDepartmentContainerComponent } from './medical-test-settings-report-templates-department-container.component';

describe('MedicalTestSettingsReportTemplatesDepartmentContainerComponent', () => {
  let component: MedicalTestSettingsReportTemplatesDepartmentContainerComponent;
  let fixture: ComponentFixture<MedicalTestSettingsReportTemplatesDepartmentContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MedicalTestSettingsReportTemplatesDepartmentContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MedicalTestSettingsReportTemplatesDepartmentContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
