import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerServiceTreatmentCaseListComponent } from './customer-service-treatment-case-list.component';

describe('CustomerServiceTreatmentCaseListComponent', () => {
  let component: CustomerServiceTreatmentCaseListComponent;
  let fixture: ComponentFixture<CustomerServiceTreatmentCaseListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CustomerServiceTreatmentCaseListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomerServiceTreatmentCaseListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
