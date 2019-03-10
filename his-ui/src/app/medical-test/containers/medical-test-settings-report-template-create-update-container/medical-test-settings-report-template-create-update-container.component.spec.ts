import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MedicalTestSettingsReportTemplateCreateUpdateContainerComponent } from './medical-test-settings-report-template-create-update-container.component';

describe('MedicalTestSettingsReportTemplateCreateUpdateContainerComponent', () => {
  let component: MedicalTestSettingsReportTemplateCreateUpdateContainerComponent;
  let fixture: ComponentFixture<MedicalTestSettingsReportTemplateCreateUpdateContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MedicalTestSettingsReportTemplateCreateUpdateContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MedicalTestSettingsReportTemplateCreateUpdateContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
