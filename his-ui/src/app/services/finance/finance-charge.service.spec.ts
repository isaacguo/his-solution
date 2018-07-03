import { TestBed, inject } from '@angular/core/testing';

import { FinanceChargeService } from './finance-charge.service';

describe('FinanceChargeService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [FinanceChargeService]
    });
  });

  it('should be created', inject([FinanceChargeService], (service: FinanceChargeService) => {
    expect(service).toBeTruthy();
  }));
});
