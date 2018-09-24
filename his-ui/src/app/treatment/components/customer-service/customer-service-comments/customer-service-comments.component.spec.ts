import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerServiceCommentsComponent } from './customer-service-comments.component';

describe('CustomerServiceCommentsComponent', () => {
  let component: CustomerServiceCommentsComponent;
  let fixture: ComponentFixture<CustomerServiceCommentsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CustomerServiceCommentsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomerServiceCommentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
