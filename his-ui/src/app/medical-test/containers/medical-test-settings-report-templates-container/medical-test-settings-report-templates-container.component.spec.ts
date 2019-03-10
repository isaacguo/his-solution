import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MedicalTestSettingsReportTemplatesContainerComponent } from './medical-test-settings-report-templates-container.component';

describe('MedicalTestSettingsReportTemplatesContainerComponent', () => {
  let component: MedicalTestSettingsReportTemplatesContainerComponent;
  let fixture: ComponentFixture<MedicalTestSettingsReportTemplatesContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MedicalTestSettingsReportTemplatesContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MedicalTestSettingsReportTemplatesContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
