import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MedicalTestSettingsReportCreateUpdateComponent } from './medical-test-settings-report-create-update.component';

describe('MedicalTestSettingsReportCreateUpdateComponent', () => {
  let component: MedicalTestSettingsReportCreateUpdateComponent;
  let fixture: ComponentFixture<MedicalTestSettingsReportCreateUpdateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MedicalTestSettingsReportCreateUpdateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MedicalTestSettingsReportCreateUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
