import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerServiceTreatmentCaseComponent } from './customer-service-treatment-case.component';

describe('CustomerServiceTreatmentCaseComponent', () => {
  let component: CustomerServiceTreatmentCaseComponent;
  let fixture: ComponentFixture<CustomerServiceTreatmentCaseComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CustomerServiceTreatmentCaseComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomerServiceTreatmentCaseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
