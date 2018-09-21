import {inject, TestBed} from '@angular/core/testing';

import {InventoryImportSheetService} from './inventory-import-sheet.service';

describe('InventoryImportSheetService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [InventoryImportSheetService]
    });
  });

  it('should be created', inject([InventoryImportSheetService], (service: InventoryImportSheetService) => {
    expect(service).toBeTruthy();
  }));
});
