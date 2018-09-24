import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerServicePetInfoComponent } from './customer-service-pet-info.component';

describe('CustomerServicePetInfoComponent', () => {
  let component: CustomerServicePetInfoComponent;
  let fixture: ComponentFixture<CustomerServicePetInfoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CustomerServicePetInfoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomerServicePetInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
