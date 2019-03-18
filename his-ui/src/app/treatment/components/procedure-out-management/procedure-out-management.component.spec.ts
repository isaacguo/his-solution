import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProcedureOutManagementComponent } from './procedure-out-management.component';

describe('ProcedureOutManagementComponent', () => {
  let component: ProcedureOutManagementComponent;
  let fixture: ComponentFixture<ProcedureOutManagementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProcedureOutManagementComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProcedureOutManagementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
