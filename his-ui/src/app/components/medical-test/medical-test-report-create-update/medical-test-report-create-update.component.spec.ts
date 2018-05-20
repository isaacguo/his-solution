import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MedicalTestReportCreateUpdateComponent } from './medical-test-report-create-update.component';

describe('MedicalTestReportCreateUpdateComponent', () => {
  let component: MedicalTestReportCreateUpdateComponent;
  let fixture: ComponentFixture<MedicalTestReportCreateUpdateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MedicalTestReportCreateUpdateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MedicalTestReportCreateUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
