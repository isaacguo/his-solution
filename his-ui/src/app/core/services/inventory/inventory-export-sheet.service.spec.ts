import {inject, TestBed} from '@angular/core/testing';

import {InventoryExportSheetService} from './inventory-export-sheet.service';

describe('InventoryExportSheetService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [InventoryExportSheetService]
    });
  });

  it('should be created', inject([InventoryExportSheetService], (service: InventoryExportSheetService) => {
    expect(service).toBeTruthy();
  }));
});
