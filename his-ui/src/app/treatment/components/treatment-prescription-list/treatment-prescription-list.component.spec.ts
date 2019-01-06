import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TreatmentPrescriptionListComponent } from './treatment-prescription-list.component';

describe('TreatmentPrescriptionListComponent', () => {
  let component: TreatmentPrescriptionListComponent;
  let fixture: ComponentFixture<TreatmentPrescriptionListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TreatmentPrescriptionListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TreatmentPrescriptionListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
