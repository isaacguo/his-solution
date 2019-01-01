import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MedicalTestSettingsReportTemplateCreateUpdateComponent } from './medical-test-settings-report-template-create-update.component';

describe('MedicalTestSettingsReportTemplateCreateUpdateComponent', () => {
  let component: MedicalTestSettingsReportTemplateCreateUpdateComponent;
  let fixture: ComponentFixture<MedicalTestSettingsReportTemplateCreateUpdateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MedicalTestSettingsReportTemplateCreateUpdateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MedicalTestSettingsReportTemplateCreateUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
