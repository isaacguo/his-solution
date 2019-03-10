import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FinancePriceManagementTreatmentContainerComponent } from './finance-price-management-treatment-container.component';

describe('FinancePriceManagementTreatmentContainerComponent', () => {
  let component: FinancePriceManagementTreatmentContainerComponent;
  let fixture: ComponentFixture<FinancePriceManagementTreatmentContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FinancePriceManagementTreatmentContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FinancePriceManagementTreatmentContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
