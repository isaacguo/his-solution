import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProcurementPurchaseComponent } from './procurement-purchase.component';

describe('ProcurementPurchaseComponent', () => {
  let component: ProcurementPurchaseComponent;
  let fixture: ComponentFixture<ProcurementPurchaseComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProcurementPurchaseComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProcurementPurchaseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
