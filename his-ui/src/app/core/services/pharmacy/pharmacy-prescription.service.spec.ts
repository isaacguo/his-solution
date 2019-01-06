import { TestBed, inject } from '@angular/core/testing';

import { PharmacyPrescriptionService } from './pharmacy-prescription.service';

describe('PharmacyPrescriptionService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PharmacyPrescriptionService]
    });
  });

  it('should be created', inject([PharmacyPrescriptionService], (service: PharmacyPrescriptionService) => {
    expect(service).toBeTruthy();
  }));
});
