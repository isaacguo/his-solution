import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {EmployeeAdminDetailComponent} from './employee-admin-detail.component';

describe('EmployeeAdminDetailComponent', () => {
  let component: EmployeeAdminDetailComponent;
  let fixture: ComponentFixture<EmployeeAdminDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmployeeAdminDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeAdminDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
