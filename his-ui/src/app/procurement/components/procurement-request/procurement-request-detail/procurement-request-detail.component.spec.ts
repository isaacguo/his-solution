import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProcurementRequestDetailComponent } from './procurement-request-detail.component';

describe('ProcurementRequestDetailComponent', () => {
  let component: ProcurementRequestDetailComponent;
  let fixture: ComponentFixture<ProcurementRequestDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProcurementRequestDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProcurementRequestDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
