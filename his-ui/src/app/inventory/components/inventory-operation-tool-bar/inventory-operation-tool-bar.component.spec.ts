import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InventoryOperationToolBarComponent } from './inventory-operation-tool-bar.component';

describe('InventoryOperationToolBarComponent', () => {
  let component: InventoryOperationToolBarComponent;
  let fixture: ComponentFixture<InventoryOperationToolBarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InventoryOperationToolBarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InventoryOperationToolBarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
