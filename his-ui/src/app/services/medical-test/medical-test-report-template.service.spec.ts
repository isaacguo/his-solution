import { TestBed, inject } from '@angular/core/testing';

import { MedicalTestReportTemplateService } from './medical-test-report-template.service';

describe('MedicalTestReportTemplateService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [MedicalTestReportTemplateService]
    });
  });

  it('should be created', inject([MedicalTestReportTemplateService], (service: MedicalTestReportTemplateService) => {
    expect(service).toBeTruthy();
  }));
});
