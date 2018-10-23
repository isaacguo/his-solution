import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TreatmentMedicalTestDetailContainerComponent } from './treatment-medical-test-detail-container.component';

describe('TreatmentMedicalTestDetailContainerComponent', () => {
  let component: TreatmentMedicalTestDetailContainerComponent;
  let fixture: ComponentFixture<TreatmentMedicalTestDetailContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TreatmentMedicalTestDetailContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TreatmentMedicalTestDetailContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
