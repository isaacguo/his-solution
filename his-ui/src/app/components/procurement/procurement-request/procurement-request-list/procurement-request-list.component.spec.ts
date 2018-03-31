import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProcurementRequestListComponent } from './procurement-request-list.component';

describe('ProcurementRequestListComponent', () => {
  let component: ProcurementRequestListComponent;
  let fixture: ComponentFixture<ProcurementRequestListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProcurementRequestListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProcurementRequestListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
