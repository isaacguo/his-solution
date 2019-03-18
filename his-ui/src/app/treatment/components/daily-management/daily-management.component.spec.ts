import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DailyManagementComponent } from './daily-management.component';

describe('DailyManagementComponent', () => {
  let component: DailyManagementComponent;
  let fixture: ComponentFixture<DailyManagementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DailyManagementComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DailyManagementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
