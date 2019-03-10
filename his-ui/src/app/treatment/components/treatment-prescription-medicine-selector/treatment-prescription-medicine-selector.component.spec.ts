import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TreatmentPrescriptionMedicineSelectorComponent } from './treatment-prescription-medicine-selector.component';

describe('TreatmentPrescriptionMedicineSelectorComponent', () => {
  let component: TreatmentPrescriptionMedicineSelectorComponent;
  let fixture: ComponentFixture<TreatmentPrescriptionMedicineSelectorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TreatmentPrescriptionMedicineSelectorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TreatmentPrescriptionMedicineSelectorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
