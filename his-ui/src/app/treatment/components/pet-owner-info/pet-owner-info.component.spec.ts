import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PetOwnerInfoComponent } from './pet-owner-info.component';

describe('PetOwnerInfoComponent', () => {
  let component: PetOwnerInfoComponent;
  let fixture: ComponentFixture<PetOwnerInfoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PetOwnerInfoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PetOwnerInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
