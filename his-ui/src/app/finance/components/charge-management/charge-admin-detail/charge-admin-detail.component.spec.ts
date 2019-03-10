import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {ChargeAdminDetailComponent} from './charge-admin-detail.component';

describe('ChargeAdminDetailComponent', () => {
  let component: ChargeAdminDetailComponent;
  let fixture: ComponentFixture<ChargeAdminDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ChargeAdminDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ChargeAdminDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
