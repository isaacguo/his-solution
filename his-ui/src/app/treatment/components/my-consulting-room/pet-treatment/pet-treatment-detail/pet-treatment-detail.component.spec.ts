import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PetTreatmentDetailComponent } from './pet-treatment-detail.component';

describe('PetTreatmentDetailComponent', () => {
  let component: PetTreatmentDetailComponent;
  let fixture: ComponentFixture<PetTreatmentDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PetTreatmentDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PetTreatmentDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
