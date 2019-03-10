import { TestBed, inject } from '@angular/core/testing';

import { GuardFactoryService } from './guard-factory.service';

describe('GuardFactoryService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [GuardFactoryService]
    });
  });

  it('should be created', inject([GuardFactoryService], (service: GuardFactoryService) => {
    expect(service).toBeTruthy();
  }));
});
