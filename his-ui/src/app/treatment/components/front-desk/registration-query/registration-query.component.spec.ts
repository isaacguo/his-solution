import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {RegistrationQueryComponent} from './registration-query.component';

describe('RegistrationQueryComponent', () => {
  let component: RegistrationQueryComponent;
  let fixture: ComponentFixture<RegistrationQueryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegistrationQueryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegistrationQueryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
