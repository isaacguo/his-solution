import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {CustomerServiceTreatmentCaseCommentsComponent} from './customer-service-treatment-case-comments.component';

describe('CustomerServiceTreatmentCaseCommentsComponent', () => {
  let component: CustomerServiceTreatmentCaseCommentsComponent;
  let fixture: ComponentFixture<CustomerServiceTreatmentCaseCommentsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CustomerServiceTreatmentCaseCommentsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomerServiceTreatmentCaseCommentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
