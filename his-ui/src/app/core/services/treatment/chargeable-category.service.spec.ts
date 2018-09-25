import { TestBed, inject } from '@angular/core/testing';

import { ChargeableCategoryService } from './chargeable-category.service';

describe('ChargeableCategoryService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ChargeableCategoryService]
    });
  });

  it('should be created', inject([ChargeableCategoryService], (service: ChargeableCategoryService) => {
    expect(service).toBeTruthy();
  }));
});
