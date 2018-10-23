import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {FinanceQueryComponent} from './finance-query.component';

describe('FinanceQueryComponent', () => {
  let component: FinanceQueryComponent;
  let fixture: ComponentFixture<FinanceQueryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FinanceQueryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FinanceQueryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
