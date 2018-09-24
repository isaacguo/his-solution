import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerServiceTreatmentDetailComponent } from './customer-service-treatment-detail.component';

describe('CustomerServiceTreatmentDetailComponent', () => {
  let component: CustomerServiceTreatmentDetailComponent;
  let fixture: ComponentFixture<CustomerServiceTreatmentDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CustomerServiceTreatmentDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomerServiceTreatmentDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
