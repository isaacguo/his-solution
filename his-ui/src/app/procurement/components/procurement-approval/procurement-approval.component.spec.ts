import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProcurementApprovalComponent } from './procurement-approval.component';

describe('ProcurementApprovalComponent', () => {
  let component: ProcurementApprovalComponent;
  let fixture: ComponentFixture<ProcurementApprovalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProcurementApprovalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProcurementApprovalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
