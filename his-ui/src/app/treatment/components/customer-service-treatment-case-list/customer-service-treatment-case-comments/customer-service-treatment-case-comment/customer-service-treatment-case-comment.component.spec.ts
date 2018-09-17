import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerServiceTreatmentCaseCommentComponent } from './customer-service-treatment-case-comment.component';

describe('CustomerServiceTreatmentCaseCommentComponent', () => {
  let component: CustomerServiceTreatmentCaseCommentComponent;
  let fixture: ComponentFixture<CustomerServiceTreatmentCaseCommentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CustomerServiceTreatmentCaseCommentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomerServiceTreatmentCaseCommentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
