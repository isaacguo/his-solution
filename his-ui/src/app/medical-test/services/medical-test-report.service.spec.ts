import {inject, TestBed} from '@angular/core/testing';

import {MedicalTestReportService} from './medical-test-report.service';

describe('MedicalTestReportTemplateService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [MedicalTestReportService]
    });
  });

  it('should be created', inject([MedicalTestReportService], (service: MedicalTestReportService) => {
    expect(service).toBeTruthy();
  }));
});
