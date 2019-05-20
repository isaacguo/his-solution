import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProcedureInManagementContainerComponent } from './procedure-in-management-container.component';

describe('ProcedureInManagementContainerComponent', () => {
  let component: ProcedureInManagementContainerComponent;
  let fixture: ComponentFixture<ProcedureInManagementContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProcedureInManagementContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProcedureInManagementContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
