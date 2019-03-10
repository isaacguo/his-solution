import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InventoryItemCreateUpdateComponent } from './inventory-item-create-update.component';

describe('InventoryItemCreateUpdateComponent', () => {
  let component: InventoryItemCreateUpdateComponent;
  let fixture: ComponentFixture<InventoryItemCreateUpdateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InventoryItemCreateUpdateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InventoryItemCreateUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
