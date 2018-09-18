import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {PetInfoComponent} from './pet-info.component';

describe('PetInfoComponent', () => {
  let component: PetInfoComponent;
  let fixture: ComponentFixture<PetInfoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PetInfoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PetInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
