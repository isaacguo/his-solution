import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TreatmentMedicalTestContainerComponent } from './treatment-medical-test-container.component';

describe('TreatmentMedicalTestContainerComponent', () => {
  let component: TreatmentMedicalTestContainerComponent;
  let fixture: ComponentFixture<TreatmentMedicalTestContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TreatmentMedicalTestContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TreatmentMedicalTestContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
