import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerServiceTreatmentCaseContainerComponent } from './customer-service-treatment-case-container.component';

describe('CustomerServiceTreatmentCaseContainerComponent', () => {
  let component: CustomerServiceTreatmentCaseContainerComponent;
  let fixture: ComponentFixture<CustomerServiceTreatmentCaseContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CustomerServiceTreatmentCaseContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomerServiceTreatmentCaseContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
