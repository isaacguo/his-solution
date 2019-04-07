import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DailyManagementDetailComponent } from './daily-management-detail.component';

describe('DailyManagementDetailComponent', () => {
  let component: DailyManagementDetailComponent;
  let fixture: ComponentFixture<DailyManagementDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DailyManagementDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DailyManagementDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
