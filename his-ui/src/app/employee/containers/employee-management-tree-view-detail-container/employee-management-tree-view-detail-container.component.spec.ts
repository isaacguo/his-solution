import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeManagementTreeViewDetailContainerComponent } from './employee-management-tree-view-detail-container.component';

describe('EmployeeManagementTreeViewDetailContainerComponent', () => {
  let component: EmployeeManagementTreeViewDetailContainerComponent;
  let fixture: ComponentFixture<EmployeeManagementTreeViewDetailContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmployeeManagementTreeViewDetailContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeManagementTreeViewDetailContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
