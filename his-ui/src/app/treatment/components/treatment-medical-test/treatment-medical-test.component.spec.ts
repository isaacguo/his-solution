import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TreatmentMedicalTestComponent } from './treatment-medical-test.component';

describe('TreatmentMedicalTestComponent', () => {
  let component: TreatmentMedicalTestComponent;
  let fixture: ComponentFixture<TreatmentMedicalTestComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TreatmentMedicalTestComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TreatmentMedicalTestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
