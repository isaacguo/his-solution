import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PatientTreatmentComponent } from './patient-treatment.component';

describe('PatientTreatmentComponent', () => {
  let component: PatientTreatmentComponent;
  let fixture: ComponentFixture<PatientTreatmentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PatientTreatmentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PatientTreatmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
