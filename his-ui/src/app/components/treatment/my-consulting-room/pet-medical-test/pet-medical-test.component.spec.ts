import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PetMedicalTestComponent } from './pet-medical-test.component';

describe('PetMedicalTestComponent', () => {
  let component: PetMedicalTestComponent;
  let fixture: ComponentFixture<PetMedicalTestComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PetMedicalTestComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PetMedicalTestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
