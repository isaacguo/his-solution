import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {EmployeeLeaveComponent} from './employee-leave.component';

describe('EmployeeLeaveComponent', () => {
  let component: EmployeeLeaveComponent;
  let fixture: ComponentFixture<EmployeeLeaveComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmployeeLeaveComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeLeaveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
