import {inject, TestBed} from '@angular/core/testing';

import {PetOwnerService} from './pet-owner.service';

describe('PetOwnerService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PetOwnerService]
    });
  });

  it('should be created', inject([PetOwnerService], (service: PetOwnerService) => {
    expect(service).toBeTruthy();
  }));
});
