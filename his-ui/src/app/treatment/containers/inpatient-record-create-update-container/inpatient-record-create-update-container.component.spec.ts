import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InpatientRecordCreateUpdateContainerComponent } from './inpatient-record-create-update-container.component';

describe('InpatientRecordCreateUpdateContainerComponent', () => {
  let component: InpatientRecordCreateUpdateContainerComponent;
  let fixture: ComponentFixture<InpatientRecordCreateUpdateContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InpatientRecordCreateUpdateContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InpatientRecordCreateUpdateContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
