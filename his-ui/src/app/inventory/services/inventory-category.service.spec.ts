import {inject, TestBed} from '@angular/core/testing';

import {InventoryCategoryService} from './inventory-category.service';

describe('InventoryCategoryService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [InventoryCategoryService]
    });
  });

  it('should be created', inject([InventoryCategoryService], (service: InventoryCategoryService) => {
    expect(service).toBeTruthy();
  }));
});
