import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ChargeAdminListComponent } from './charge-admin-list.component';

describe('ChargeAdminListComponent', () => {
  let component: ChargeAdminListComponent;
  let fixture: ComponentFixture<ChargeAdminListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ChargeAdminListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ChargeAdminListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
