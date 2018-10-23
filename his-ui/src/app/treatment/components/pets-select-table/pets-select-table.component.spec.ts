import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PetsSelectTableComponent } from './pets-select-table.component';

describe('PetsSelectTableComponent', () => {
  let component: PetsSelectTableComponent;
  let fixture: ComponentFixture<PetsSelectTableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PetsSelectTableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PetsSelectTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
