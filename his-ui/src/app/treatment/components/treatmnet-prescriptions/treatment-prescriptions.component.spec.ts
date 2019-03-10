import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TreatmentPrescriptionsComponent } from './treatment-prescriptions.component';

describe('TreatmentPrescriptionsComponent', () => {
  let component: TreatmentPrescriptionsComponent;
  let fixture: ComponentFixture<TreatmentPrescriptionsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TreatmentPrescriptionsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TreatmentPrescriptionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
