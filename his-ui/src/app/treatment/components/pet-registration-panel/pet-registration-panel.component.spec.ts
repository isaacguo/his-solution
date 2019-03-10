import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PetRegistrationPanelComponent } from './pet-registration-panel.component';

describe('PetRegistrationPanelComponent', () => {
  let component: PetRegistrationPanelComponent;
  let fixture: ComponentFixture<PetRegistrationPanelComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PetRegistrationPanelComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PetRegistrationPanelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
