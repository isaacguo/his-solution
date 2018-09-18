import {inject, TestBed} from '@angular/core/testing';

import {ProcurementStatusService} from './procurement-status.service';

describe('ProcurementStatusService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ProcurementStatusService]
    });
  });

  it('should be created', inject([ProcurementStatusService], (service: ProcurementStatusService) => {
    expect(service).toBeTruthy();
  }));
});
