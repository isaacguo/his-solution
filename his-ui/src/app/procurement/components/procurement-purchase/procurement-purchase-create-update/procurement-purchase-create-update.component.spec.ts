import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {ProcurementPurchaseCreateUpdateComponent} from './procurement-purchase-create-update.component';

describe('ProcurementPurchaseCreateUpdateComponent', () => {
  let component: ProcurementPurchaseCreateUpdateComponent;
  let fixture: ComponentFixture<ProcurementPurchaseCreateUpdateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProcurementPurchaseCreateUpdateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProcurementPurchaseCreateUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
