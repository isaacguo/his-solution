import {inject, TestBed} from '@angular/core/testing';

import {TreatmentCaseService} from './treatment-case.service';

describe('TreatmentCaseService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [TreatmentCaseService]
    });
  });

  it('should be created', inject([TreatmentCaseService], (service: TreatmentCaseService) => {
    expect(service).toBeTruthy();
  }));
});
