import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MedicalTestSettingsReportComponent } from './medical-test-settings-report.component';

describe('MedicalTestSettingsReportComponent', () => {
  let component: MedicalTestSettingsReportComponent;
  let fixture: ComponentFixture<MedicalTestSettingsReportComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MedicalTestSettingsReportComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MedicalTestSettingsReportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
