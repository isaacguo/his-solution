import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProcedureInManagementComponent } from './procedure-in-management.component';

describe('ProcedureInManagementComponent', () => {
  let component: ProcedureInManagementComponent;
  let fixture: ComponentFixture<ProcedureInManagementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProcedureInManagementComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProcedureInManagementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
