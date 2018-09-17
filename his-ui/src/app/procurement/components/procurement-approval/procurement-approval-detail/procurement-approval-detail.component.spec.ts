import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProcurementApprovalDetailComponent } from './procurement-approval-detail.component';

describe('ProcurementApprovalDetailComponent', () => {
  let component: ProcurementApprovalDetailComponent;
  let fixture: ComponentFixture<ProcurementApprovalDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProcurementApprovalDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProcurementApprovalDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
