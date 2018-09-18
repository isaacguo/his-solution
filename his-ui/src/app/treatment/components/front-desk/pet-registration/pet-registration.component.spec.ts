import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {PetRegistrationComponent} from './pet-registration.component';

describe('PetRegistrationComponent', () => {
  let component: PetRegistrationComponent;
  let fixture: ComponentFixture<PetRegistrationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PetRegistrationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PetRegistrationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
