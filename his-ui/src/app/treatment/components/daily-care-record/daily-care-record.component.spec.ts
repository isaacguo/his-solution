import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DailyCareRecordComponent } from './daily-care-record.component';

describe('DailyCareRecordComponent', () => {
  let component: DailyCareRecordComponent;
  let fixture: ComponentFixture<DailyCareRecordComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DailyCareRecordComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DailyCareRecordComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
