import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AuthorizationContainerComponent } from './authorization-container.component';

describe('AuthorizationContainerComponent', () => {
  let component: AuthorizationContainerComponent;
  let fixture: ComponentFixture<AuthorizationContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AuthorizationContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AuthorizationContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
