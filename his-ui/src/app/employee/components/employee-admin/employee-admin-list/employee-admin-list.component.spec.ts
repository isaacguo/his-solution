import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {EmployeeAdminListComponent} from './employee-admin-list.component';

describe('EmployeeAdminListComponent', () => {
  let component: EmployeeAdminListComponent;
  let fixture: ComponentFixture<EmployeeAdminListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmployeeAdminListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeAdminListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
