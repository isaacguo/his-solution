import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PetTreatmentContainerComponent } from './pet-treatment-container.component';

describe('PetTreatmentContainerComponent', () => {
  let component: PetTreatmentContainerComponent;
  let fixture: ComponentFixture<PetTreatmentContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PetTreatmentContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PetTreatmentContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
