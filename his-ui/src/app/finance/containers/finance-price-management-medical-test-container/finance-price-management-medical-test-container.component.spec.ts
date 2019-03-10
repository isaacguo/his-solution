import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FinancePriceManagementMedicalTestContainerComponent } from './finance-price-management-medical-test-container.component';

describe('FinancePriceManagementMedicalTestContainerComponent', () => {
  let component: FinancePriceManagementMedicalTestContainerComponent;
  let fixture: ComponentFixture<FinancePriceManagementMedicalTestContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FinancePriceManagementMedicalTestContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FinancePriceManagementMedicalTestContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
