import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FinanceChargeManagementContainerComponent } from './finance-charge-management-container.component';

describe('FinanceChargeManagementContainerComponent', () => {
  let component: FinanceChargeManagementContainerComponent;
  let fixture: ComponentFixture<FinanceChargeManagementContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FinanceChargeManagementContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FinanceChargeManagementContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
