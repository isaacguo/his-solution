import { TestBed, inject } from '@angular/core/testing';

import { MedicalTestReportService } from './medical-test-report-template.service';

describe('MedicalTestReportService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [MedicalTestReportService]
    });
  });

  it('should be created', inject([MedicalTestReportService], (service: MedicalTestReportService) => {
    expect(service).toBeTruthy();
  }));
});
