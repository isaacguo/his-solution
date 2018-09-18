import {inject, TestBed} from '@angular/core/testing';

import {TreatmentEmployeeService} from './treatment-employee.service';

describe('TreatmentEmployeeService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [TreatmentEmployeeService]
    });
  });

  it('should be created', inject([TreatmentEmployeeService], (service: TreatmentEmployeeService) => {
    expect(service).toBeTruthy();
  }));
});
