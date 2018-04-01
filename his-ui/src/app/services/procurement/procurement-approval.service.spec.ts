import { TestBed, inject } from '@angular/core/testing';

import { ProcurementApprovalService } from './procurement-approval.service';

describe('ProcurementApprovalService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ProcurementApprovalService]
    });
  });

  it('should be created', inject([ProcurementApprovalService], (service: ProcurementApprovalService) => {
    expect(service).toBeTruthy();
  }));
});
