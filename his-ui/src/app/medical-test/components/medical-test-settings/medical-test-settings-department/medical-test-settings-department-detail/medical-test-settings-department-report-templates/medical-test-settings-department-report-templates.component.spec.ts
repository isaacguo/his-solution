import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {MedicalTestSettingsDepartmentReportTemplatesComponent} from './medical-test-settings-department-report-templates.component';

describe('MedicalTestSettingsDepartmentReportTemplatesComponent', () => {
  let component: MedicalTestSettingsDepartmentReportTemplatesComponent;
  let fixture: ComponentFixture<MedicalTestSettingsDepartmentReportTemplatesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MedicalTestSettingsDepartmentReportTemplatesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MedicalTestSettingsDepartmentReportTemplatesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
