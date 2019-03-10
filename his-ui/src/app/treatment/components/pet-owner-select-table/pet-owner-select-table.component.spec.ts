import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PetOwnerSelectTableComponent } from './pet-owner-select-table.component';

describe('PetOwnerSelectTableComponent', () => {
  let component: PetOwnerSelectTableComponent;
  let fixture: ComponentFixture<PetOwnerSelectTableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PetOwnerSelectTableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PetOwnerSelectTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
