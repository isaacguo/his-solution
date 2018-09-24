import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerServiceTreatmentCaseInfoContainerComponent } from './customer-service-treatment-case-info-container.component';

describe('CustomerServiceTreatmentCaseInfoContainerComponent', () => {
  let component: CustomerServiceTreatmentCaseInfoContainerComponent;
  let fixture: ComponentFixture<CustomerServiceTreatmentCaseInfoContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CustomerServiceTreatmentCaseInfoContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomerServiceTreatmentCaseInfoContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
