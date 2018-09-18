import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {ProcurementManagementComponent} from './procurement-management.component';

describe('ProcurementManagementComponent', () => {
  let component: ProcurementManagementComponent;
  let fixture: ComponentFixture<ProcurementManagementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProcurementManagementComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProcurementManagementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
