import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {ProcurementPurchaseDetailComponent} from './procurement-purchase-detail.component';

describe('ProcurementPurchaseDetailComponent', () => {
  let component: ProcurementPurchaseDetailComponent;
  let fixture: ComponentFixture<ProcurementPurchaseDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProcurementPurchaseDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProcurementPurchaseDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
