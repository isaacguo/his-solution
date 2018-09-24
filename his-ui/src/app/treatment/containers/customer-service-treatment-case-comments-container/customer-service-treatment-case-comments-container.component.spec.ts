import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerServiceTreatmentCaseCommentsContainerComponent } from './customer-service-treatment-case-comments-container.component';

describe('CustomerServiceTreatmentCaseCommentsContainerComponent', () => {
  let component: CustomerServiceTreatmentCaseCommentsContainerComponent;
  let fixture: ComponentFixture<CustomerServiceTreatmentCaseCommentsContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CustomerServiceTreatmentCaseCommentsContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomerServiceTreatmentCaseCommentsContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
