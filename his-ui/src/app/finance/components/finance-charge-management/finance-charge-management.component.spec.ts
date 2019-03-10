import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FinanceChargeManagementComponent } from './finance-charge-management.component';

describe('FinanceChargeManagementComponent', () => {
  let component: FinanceChargeManagementComponent;
  let fixture: ComponentFixture<FinanceChargeManagementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FinanceChargeManagementComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FinanceChargeManagementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
