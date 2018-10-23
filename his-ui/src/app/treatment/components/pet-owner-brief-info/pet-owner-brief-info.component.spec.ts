import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PetOwnerBriefInfoComponent } from './pet-owner-brief-info.component';

describe('PetOwnerBriefInfoComponent', () => {
  let component: PetOwnerBriefInfoComponent;
  let fixture: ComponentFixture<PetOwnerBriefInfoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PetOwnerBriefInfoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PetOwnerBriefInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
