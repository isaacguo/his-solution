import {inject, TestBed} from '@angular/core/testing';

import {EmployeeDepartmentService} from './employee-department.service';

describe('EmployeeDepartmentService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [EmployeeDepartmentService]
    });
  });

  it('should be created', inject([EmployeeDepartmentService], (service: EmployeeDepartmentService) => {
    expect(service).toBeTruthy();
  }));
});
