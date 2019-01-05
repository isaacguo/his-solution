import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TreatmentMedicalTestReportDetailComponent } from './treatment-medical-test-report-detail.component';

describe('TreatmentMedicalTestReportDetailComponent', () => {
  let component: TreatmentMedicalTestReportDetailComponent;
  let fixture: ComponentFixture<TreatmentMedicalTestReportDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TreatmentMedicalTestReportDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TreatmentMedicalTestReportDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
