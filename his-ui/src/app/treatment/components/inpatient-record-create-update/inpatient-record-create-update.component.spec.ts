import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InpatientRecordCreateUpdateComponent } from './inpatient-record-create-update.component';

describe('InpatientRecordCreateUpdateComponent', () => {
  let component: InpatientRecordCreateUpdateComponent;
  let fixture: ComponentFixture<InpatientRecordCreateUpdateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InpatientRecordCreateUpdateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InpatientRecordCreateUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
