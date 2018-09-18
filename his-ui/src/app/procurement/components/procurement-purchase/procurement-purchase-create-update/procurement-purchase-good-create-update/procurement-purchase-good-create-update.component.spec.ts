import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {ProcurementPurchaseGoodCreateUpdateComponent} from './procurement-purchase-good-create-update.component';

describe('ProcurementPurchaseGoodCreateUpdateComponent', () => {
  let component: ProcurementPurchaseGoodCreateUpdateComponent;
  let fixture: ComponentFixture<ProcurementPurchaseGoodCreateUpdateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProcurementPurchaseGoodCreateUpdateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProcurementPurchaseGoodCreateUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
