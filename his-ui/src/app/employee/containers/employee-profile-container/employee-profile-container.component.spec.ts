import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeProfileContainerComponent } from './employee-profile-container.component';

describe('EmployeeProfileContainerComponent', () => {
  let component: EmployeeProfileContainerComponent;
  let fixture: ComponentFixture<EmployeeProfileContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmployeeProfileContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeProfileContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
