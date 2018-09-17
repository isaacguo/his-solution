import { TestBed, inject } from '@angular/core/testing';

import { FinancePriceService } from './finance-price.service';

describe('FinancePriceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [FinancePriceService]
    });
  });

  it('should be created', inject([FinancePriceService], (service: FinancePriceService) => {
    expect(service).toBeTruthy();
  }));
});
