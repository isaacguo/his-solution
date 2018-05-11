import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeProfileEditComponent } from './employee-profile-edit.component';

describe('EmployeeProfileEditComponent', () => {
  let component: EmployeeProfileEditComponent;
  let fixture: ComponentFixture<EmployeeProfileEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmployeeProfileEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeProfileEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
