import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InventoryQueryContainerComponent } from './inventory-query-container.component';

describe('InventoryQueryContainerComponent', () => {
  let component: InventoryQueryContainerComponent;
  let fixture: ComponentFixture<InventoryQueryContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InventoryQueryContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InventoryQueryContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
