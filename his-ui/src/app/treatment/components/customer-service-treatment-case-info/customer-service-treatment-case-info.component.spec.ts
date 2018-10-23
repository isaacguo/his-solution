import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerServiceTreatmentCaseInfoComponent } from './customer-service-treatment-case-info.component';

describe('CustomerServiceTreatmentCaseInfoComponent', () => {
  let component: CustomerServiceTreatmentCaseInfoComponent;
  let fixture: ComponentFixture<CustomerServiceTreatmentCaseInfoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CustomerServiceTreatmentCaseInfoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomerServiceTreatmentCaseInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
