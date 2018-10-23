import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeManagementTreeViewContainerComponent } from './employee-management-tree-view-container.component';

describe('EmployeeManagementTreeViewContainerComponent', () => {
  let component: EmployeeManagementTreeViewContainerComponent;
  let fixture: ComponentFixture<EmployeeManagementTreeViewContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmployeeManagementTreeViewContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeManagementTreeViewContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
