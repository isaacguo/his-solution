import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {InventoryQueryComponent} from './inventory-query.component';

describe('InventoryQueryComponent', () => {
  let component: InventoryQueryComponent;
  let fixture: ComponentFixture<InventoryQueryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InventoryQueryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InventoryQueryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
