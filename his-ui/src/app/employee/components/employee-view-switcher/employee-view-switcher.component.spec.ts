import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeViewSwitcherComponent } from './employee-view-switcher.component';

describe('EmployeeViewSwitcherComponent', () => {
  let component: EmployeeViewSwitcherComponent;
  let fixture: ComponentFixture<EmployeeViewSwitcherComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmployeeViewSwitcherComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeViewSwitcherComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
