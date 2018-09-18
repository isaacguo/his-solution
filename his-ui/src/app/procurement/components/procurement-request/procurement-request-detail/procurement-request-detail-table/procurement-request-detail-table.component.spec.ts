import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {ProcurementRequestDetailTableComponent} from './procurement-request-detail-table.component';

describe('ProcurementRequestDetailTableComponent', () => {
  let component: ProcurementRequestDetailTableComponent;
  let fixture: ComponentFixture<ProcurementRequestDetailTableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProcurementRequestDetailTableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProcurementRequestDetailTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
