import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerServiceTreatmentCaseDetailComponent } from './customer-service-treatment-case-detail.component';

describe('CustomerServiceTreatmentCaseDetailComponent', () => {
  let component: CustomerServiceTreatmentCaseDetailComponent;
  let fixture: ComponentFixture<CustomerServiceTreatmentCaseDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CustomerServiceTreatmentCaseDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomerServiceTreatmentCaseDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
