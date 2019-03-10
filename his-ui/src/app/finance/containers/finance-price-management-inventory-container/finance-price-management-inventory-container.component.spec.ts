import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FinancePriceManagementInventoryContainerComponent } from './finance-price-management-inventory-container.component';

describe('FinancePriceManagementInventoryContainerComponent', () => {
  let component: FinancePriceManagementInventoryContainerComponent;
  let fixture: ComponentFixture<FinancePriceManagementInventoryContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FinancePriceManagementInventoryContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FinancePriceManagementInventoryContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
