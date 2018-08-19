import { TestBed, inject } from '@angular/core/testing';

import { ProductImportReceiptService } from './product-import-receipt.service';

describe('ProductImportReceiptService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ProductImportReceiptService]
    });
  });

  it('should be created', inject([ProductImportReceiptService], (service: ProductImportReceiptService) => {
    expect(service).toBeTruthy();
  }));
});
