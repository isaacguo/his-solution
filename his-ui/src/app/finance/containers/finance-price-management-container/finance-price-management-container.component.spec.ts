import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FinancePriceManagementContainerComponent } from './finance-price-management-container.component';

describe('FinancePriceManagementContainerComponent', () => {
  let component: FinancePriceManagementContainerComponent;
  let fixture: ComponentFixture<FinancePriceManagementContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FinancePriceManagementContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FinancePriceManagementContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
