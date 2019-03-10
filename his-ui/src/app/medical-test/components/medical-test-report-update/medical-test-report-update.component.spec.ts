import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MedicalTestReportUpdateComponent } from './medical-test-report-update.component';

describe('MedicalTestReportUpdateComponent', () => {
  let component: MedicalTestReportUpdateComponent;
  let fixture: ComponentFixture<MedicalTestReportUpdateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MedicalTestReportUpdateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MedicalTestReportUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
