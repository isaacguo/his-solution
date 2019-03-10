import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistrationQueryContainerComponent } from './registration-query-container.component';

describe('RegistrationQueryContainerComponent', () => {
  let component: RegistrationQueryContainerComponent;
  let fixture: ComponentFixture<RegistrationQueryContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegistrationQueryContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegistrationQueryContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
