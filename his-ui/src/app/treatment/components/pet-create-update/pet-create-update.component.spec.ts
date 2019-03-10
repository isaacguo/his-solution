import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PetCreateUpdateComponent } from './pet-create-update.component';

describe('PetCreateUpdateComponent', () => {
  let component: PetCreateUpdateComponent;
  let fixture: ComponentFixture<PetCreateUpdateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PetCreateUpdateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PetCreateUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
