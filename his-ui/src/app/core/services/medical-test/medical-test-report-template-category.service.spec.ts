import {inject, TestBed} from '@angular/core/testing';

import {MedicalTestReportTemplateCategoryService} from './medical-test-report-template-category.service';

describe('MedicalTestReportTemplateCategoryService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [MedicalTestReportTemplateCategoryService]
    });
  });

  it('should be created', inject([MedicalTestReportTemplateCategoryService], (service: MedicalTestReportTemplateCategoryService) => {
    expect(service).toBeTruthy();
  }));
});
