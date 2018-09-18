import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {InventoryQueryListComponent} from './inventory-query-list.component';

describe('InventoryQueryListComponent', () => {
  let component: InventoryQueryListComponent;
  let fixture: ComponentFixture<InventoryQueryListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InventoryQueryListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InventoryQueryListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
