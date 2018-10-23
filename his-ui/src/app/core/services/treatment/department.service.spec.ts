import {inject, TestBed} from '@angular/core/testing';

import {TreatmentDepartmentService} from './treatment-department.service';

describe('TreatmentDepartmentService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [TreatmentDepartmentService]
    });
  });

  it('should be created', inject([TreatmentDepartmentService], (service: TreatmentDepartmentService) => {
    expect(service).toBeTruthy();
  }));
});
