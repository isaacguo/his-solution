import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeProfilePictureComponent } from './employee-profile-picture.component';

describe('EmployeeProfilePictureComponent', () => {
  let component: EmployeeProfilePictureComponent;
  let fixture: ComponentFixture<EmployeeProfilePictureComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmployeeProfilePictureComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeProfilePictureComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
