import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerServiceCommentComponent } from './customer-service-comment.component';

describe('CustomerServiceCommentComponent', () => {
  let component: CustomerServiceCommentComponent;
  let fixture: ComponentFixture<CustomerServiceCommentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CustomerServiceCommentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomerServiceCommentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
