import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TreatmentPrescriptionDetailContainerComponent } from './treatment-prescription-detail-container.component';

describe('TreatmentPrescriptionDetailContainerComponent', () => {
  let component: TreatmentPrescriptionDetailContainerComponent;
  let fixture: ComponentFixture<TreatmentPrescriptionDetailContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TreatmentPrescriptionDetailContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TreatmentPrescriptionDetailContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
