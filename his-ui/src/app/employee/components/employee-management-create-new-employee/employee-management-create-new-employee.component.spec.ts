import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeManagementCreateNewEmployeeComponent } from './employee-management-create-new-employee.component';

describe('EmployeeManagementCreateNewEmployeeComponent', () => {
  let component: EmployeeManagementCreateNewEmployeeComponent;
  let fixture: ComponentFixture<EmployeeManagementCreateNewEmployeeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmployeeManagementCreateNewEmployeeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeManagementCreateNewEmployeeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
