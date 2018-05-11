import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProcurementTableListViewComponent } from './procurement-table-list-view.component';

describe('ProcurementTableListViewComponent', () => {
  let component: ProcurementTableListViewComponent;
  let fixture: ComponentFixture<ProcurementTableListViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProcurementTableListViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProcurementTableListViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
