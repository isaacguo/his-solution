import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PetInfoContainerComponent } from './pet-info-container.component';

describe('PetInfoContainerComponent', () => {
  let component: PetInfoContainerComponent;
  let fixture: ComponentFixture<PetInfoContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PetInfoContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PetInfoContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
