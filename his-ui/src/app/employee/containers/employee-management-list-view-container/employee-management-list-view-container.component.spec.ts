import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeManagementListViewContainerComponent } from './employee-management-list-view-container.component';

describe('EmployeeManagementListViewContainerComponent', () => {
  let component: EmployeeManagementListViewContainerComponent;
  let fixture: ComponentFixture<EmployeeManagementListViewContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmployeeManagementListViewContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeManagementListViewContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
