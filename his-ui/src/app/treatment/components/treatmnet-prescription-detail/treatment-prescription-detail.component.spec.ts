import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TreatmentPrescriptionDetailComponent } from './treatment-prescription-detail.component';

describe('TreatmentPrescriptionDetailComponent', () => {
  let component: TreatmentPrescriptionDetailComponent;
  let fixture: ComponentFixture<TreatmentPrescriptionDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TreatmentPrescriptionDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TreatmentPrescriptionDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
