import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeLeaveContainerComponent } from './employee-leave-container.component';

describe('EmployeeLeaveContainerComponent', () => {
  let component: EmployeeLeaveContainerComponent;
  let fixture: ComponentFixture<EmployeeLeaveContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmployeeLeaveContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeLeaveContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
