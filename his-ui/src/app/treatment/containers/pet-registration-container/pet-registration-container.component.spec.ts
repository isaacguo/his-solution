import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PetRegistrationContainerComponent } from './pet-registration-container.component';

describe('PetRegistrationContainerComponent', () => {
  let component: PetRegistrationContainerComponent;
  let fixture: ComponentFixture<PetRegistrationContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PetRegistrationContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PetRegistrationContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
