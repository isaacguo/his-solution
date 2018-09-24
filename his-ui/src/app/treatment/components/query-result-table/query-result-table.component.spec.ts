import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { QueryResultTableComponent } from './query-result-table.component';

describe('QueryResultTableComponent', () => {
  let component: QueryResultTableComponent;
  let fixture: ComponentFixture<QueryResultTableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ QueryResultTableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(QueryResultTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
