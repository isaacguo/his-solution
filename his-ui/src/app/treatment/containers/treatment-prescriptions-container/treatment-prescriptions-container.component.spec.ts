import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TreatmentPrescriptionsContainerComponent } from './treatment-prescriptions-container.component';

describe('TreatmentPrescriptionsContainerComponent', () => {
  let component: TreatmentPrescriptionsContainerComponent;
  let fixture: ComponentFixture<TreatmentPrescriptionsContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TreatmentPrescriptionsContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TreatmentPrescriptionsContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
