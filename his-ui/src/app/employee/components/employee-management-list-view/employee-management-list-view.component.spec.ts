import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeManagementListViewComponent } from './employee-management-list-view.component';

describe('EmployeeManagementListViewComponent', () => {
  let component: EmployeeManagementListViewComponent;
  let fixture: ComponentFixture<EmployeeManagementListViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmployeeManagementListViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeManagementListViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
