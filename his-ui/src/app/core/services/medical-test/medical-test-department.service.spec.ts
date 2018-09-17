import { TestBed, inject } from '@angular/core/testing';

import { MedicalTestDepartmentService } from './medical-test-department.service';

describe('MedicalTestDepartmentService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [MedicalTestDepartmentService]
    });
  });

  it('should be created', inject([MedicalTestDepartmentService], (service: MedicalTestDepartmentService) => {
    expect(service).toBeTruthy();
  }));
});
