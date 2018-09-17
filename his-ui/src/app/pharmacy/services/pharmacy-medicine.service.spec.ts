import { TestBed, inject } from '@angular/core/testing';

import { PharmacyMedicineService } from './pharmacy-medicine.service';

describe('PharmacyMedicineService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PharmacyMedicineService]
    });
  });

  it('should be created', inject([PharmacyMedicineService], (service: PharmacyMedicineService) => {
    expect(service).toBeTruthy();
  }));
});
