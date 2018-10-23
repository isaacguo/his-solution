import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TreatmentCaseQueryResultTableComponent } from './treatment-case-query-result-table.component';

describe('TreatmentCaseQueryResultTableComponent', () => {
  let component: TreatmentCaseQueryResultTableComponent;
  let fixture: ComponentFixture<TreatmentCaseQueryResultTableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TreatmentCaseQueryResultTableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TreatmentCaseQueryResultTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
