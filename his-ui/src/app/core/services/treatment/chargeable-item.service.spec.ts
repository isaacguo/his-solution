import { TestBed, inject } from '@angular/core/testing';

import { ChargeableItemService } from './chargeable-item.service';

describe('ChargeableItemService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ChargeableItemService]
    });
  });

  it('should be created', inject([ChargeableItemService], (service: ChargeableItemService) => {
    expect(service).toBeTruthy();
  }));
});
