import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProcurementApprovalListComponent } from './procurement-approval-list.component';

describe('ProcurementApprovalListComponent', () => {
  let component: ProcurementApprovalListComponent;
  let fixture: ComponentFixture<ProcurementApprovalListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProcurementApprovalListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProcurementApprovalListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
