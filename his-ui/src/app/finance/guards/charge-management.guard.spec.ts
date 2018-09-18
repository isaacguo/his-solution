import {inject, TestBed} from '@angular/core/testing';

import {ChargeManagementGuard} from './charge-management.guard';

describe('ChargeManagementGuard', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ChargeManagementGuard]
    });
  });

  it('should ...', inject([ChargeManagementGuard], (guard: ChargeManagementGuard) => {
    expect(guard).toBeTruthy();
  }));
});
