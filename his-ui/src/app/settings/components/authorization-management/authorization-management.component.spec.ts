import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {AuthorizationManagementComponent} from './authorization-management.component';

describe('AuthorizationManagementComponent', () => {
  let component: AuthorizationManagementComponent;
  let fixture: ComponentFixture<AuthorizationManagementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AuthorizationManagementComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AuthorizationManagementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
