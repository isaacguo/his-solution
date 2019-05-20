import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InpatientRecordRequestComponent } from './inpatient-record-request.component';

describe('InpatientRecordRequestComponent', () => {
  let component: InpatientRecordRequestComponent;
  let fixture: ComponentFixture<InpatientRecordRequestComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InpatientRecordRequestComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InpatientRecordRequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
