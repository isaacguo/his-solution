import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PetOwnerCreateUpdateComponent } from './pet-owner-create-update.component';

describe('PetOwnerCreateUpdateComponent', () => {
  let component: PetOwnerCreateUpdateComponent;
  let fixture: ComponentFixture<PetOwnerCreateUpdateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PetOwnerCreateUpdateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PetOwnerCreateUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
