import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DailyManagementContainerComponent } from './daily-management-container.component';

describe('DailyManagementContainerComponent', () => {
  let component: DailyManagementContainerComponent;
  let fixture: ComponentFixture<DailyManagementContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DailyManagementContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DailyManagementContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
