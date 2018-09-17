import { TestBed, inject } from '@angular/core/testing';

import { ProcurementRequestService } from './procurement-request.service';

describe('ProcurementRequestService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ProcurementRequestService]
    });
  });

  it('should be created', inject([ProcurementRequestService], (service: ProcurementRequestService) => {
    expect(service).toBeTruthy();
  }));
});
