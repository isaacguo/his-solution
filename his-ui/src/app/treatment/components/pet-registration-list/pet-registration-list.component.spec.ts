import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PetRegistrationListComponent } from './pet-registration-list.component';

describe('PetRegistrationListComponent', () => {
  let component: PetRegistrationListComponent;
  let fixture: ComponentFixture<PetRegistrationListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PetRegistrationListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PetRegistrationListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
