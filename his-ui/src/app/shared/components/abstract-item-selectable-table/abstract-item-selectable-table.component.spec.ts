import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AbstractItemSelectableTableComponent } from './abstract-item-selectable-table.component';

describe('AbstractItemSelectableTableComponent', () => {
  let component: AbstractItemSelectableTableComponent;
  let fixture: ComponentFixture<AbstractItemSelectableTableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AbstractItemSelectableTableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AbstractItemSelectableTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
