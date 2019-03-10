import { TestBed, inject } from '@angular/core/testing';

import { VendorCategoryService } from './vendor-category.service';

describe('VendorProductCategoryService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [VendorCategoryService]
    });
  });

  it('should be created', inject([VendorCategoryService], (service: VendorCategoryService) => {
    expect(service).toBeTruthy();
  }));
});
