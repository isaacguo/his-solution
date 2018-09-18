import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {PetTreatmentComponent} from './pet-treatment.component';

describe('PetTreatmentComponent', () => {
  let component: PetTreatmentComponent;
  let fixture: ComponentFixture<PetTreatmentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PetTreatmentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PetTreatmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
