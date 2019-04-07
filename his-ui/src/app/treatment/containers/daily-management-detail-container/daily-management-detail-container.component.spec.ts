import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DailyManagementDetailContainerComponent } from './daily-management-detail-container.component';

describe('DailyManagementDetailContainerComponent', () => {
  let component: DailyManagementDetailContainerComponent;
  let fixture: ComponentFixture<DailyManagementDetailContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DailyManagementDetailContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DailyManagementDetailContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
