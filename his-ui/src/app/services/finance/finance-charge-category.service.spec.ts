import { TestBed, inject } from '@angular/core/testing';

import { FinanceChargeCategoryService } from './finance-charge-category.service';

describe('FinanceChargeCategoryService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [FinanceChargeCategoryService]
    });
  });

  it('should be created', inject([FinanceChargeCategoryService], (service: FinanceChargeCategoryService) => {
    expect(service).toBeTruthy();
  }));
});
