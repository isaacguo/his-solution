import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProcedureOutManagementContainerComponent } from './procedure-out-management-container.component';

describe('ProcedureOutManagementContainerComponent', () => {
  let component: ProcedureOutManagementContainerComponent;
  let fixture: ComponentFixture<ProcedureOutManagementContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProcedureOutManagementContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProcedureOutManagementContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
