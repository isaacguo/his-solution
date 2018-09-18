import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {CustomerServiceTreatmentCaseOutletComponent} from './customer-service-treatment-case-outlet.component';

describe('CustomerServiceTreatmentCaseOutletComponent', () => {
  let component: CustomerServiceTreatmentCaseOutletComponent;
  let fixture: ComponentFixture<CustomerServiceTreatmentCaseOutletComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CustomerServiceTreatmentCaseOutletComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomerServiceTreatmentCaseOutletComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
