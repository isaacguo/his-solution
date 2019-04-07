import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DailyCareRecordContainerComponent } from './daily-care-record-container.component';

describe('DailyCareRecordContainerComponent', () => {
  let component: DailyCareRecordContainerComponent;
  let fixture: ComponentFixture<DailyCareRecordContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DailyCareRecordContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DailyCareRecordContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
