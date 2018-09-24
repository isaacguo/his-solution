import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerServiceContainerComponent } from './customer-service-container.component';

describe('CustomerServiceContainerComponent', () => {
  let component: CustomerServiceContainerComponent;
  let fixture: ComponentFixture<CustomerServiceContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CustomerServiceContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomerServiceContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
