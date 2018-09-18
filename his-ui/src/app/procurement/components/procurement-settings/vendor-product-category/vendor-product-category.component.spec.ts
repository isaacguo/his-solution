import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {VendorProductCategoryComponent} from './vendor-product-category.component';

describe('VendorProductCategoryComponent', () => {
  let component: VendorProductCategoryComponent;
  let fixture: ComponentFixture<VendorProductCategoryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VendorProductCategoryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VendorProductCategoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
