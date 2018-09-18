import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {EmployeeAdminListOnlyComponent} from './employee-admin-list-only.component';

describe('EmployeeAdminListOnlyComponent', () => {
  let component: EmployeeAdminListOnlyComponent;
  let fixture: ComponentFixture<EmployeeAdminListOnlyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmployeeAdminListOnlyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeAdminListOnlyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
