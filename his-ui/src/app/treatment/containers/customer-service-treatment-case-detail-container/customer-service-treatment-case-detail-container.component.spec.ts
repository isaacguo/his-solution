import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerServiceTreatmentCaseDetailContainerComponent } from './customer-service-treatment-case-detail-container.component';

describe('CustomerServiceTreatmentCaseDetailContainerComponent', () => {
  let component: CustomerServiceTreatmentCaseDetailContainerComponent;
  let fixture: ComponentFixture<CustomerServiceTreatmentCaseDetailContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CustomerServiceTreatmentCaseDetailContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomerServiceTreatmentCaseDetailContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
