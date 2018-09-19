import {inject, TestBed} from '@angular/core/testing';

import {FactoryResetService} from './factory-reset.service';

describe('FactoryResetService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [FactoryResetService]
    });
  });

  it('should be created', inject([FactoryResetService], (service: FactoryResetService) => {
    expect(service).toBeTruthy();
  }));
});
