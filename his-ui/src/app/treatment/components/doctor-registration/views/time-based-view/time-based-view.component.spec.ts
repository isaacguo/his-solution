import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {TimeBasedViewComponent} from './time-based-view.component';

describe('TimeBasedViewComponent', () => {
  let component: TimeBasedViewComponent;
  let fixture: ComponentFixture<TimeBasedViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TimeBasedViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TimeBasedViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
