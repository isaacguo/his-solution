import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {ProcurementPurchaseListComponent} from './procurement-purchase-list.component';

describe('ProcurementPurchaseListComponent', () => {
  let component: ProcurementPurchaseListComponent;
  let fixture: ComponentFixture<ProcurementPurchaseListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProcurementPurchaseListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProcurementPurchaseListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
