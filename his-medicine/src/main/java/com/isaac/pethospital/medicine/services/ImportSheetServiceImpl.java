package com.isaac.pethospital.medicine.services;

import com.isaac.pethospital.common.services.AbstractCrudService;
import com.isaac.pethospital.medicine.dtos.ImportSheetOperationRequest;
import com.isaac.pethospital.medicine.entities.ImportSheetEntity;
import com.isaac.pethospital.medicine.entities.InventoryCategoryEntity;
import com.isaac.pethospital.medicine.repository.ImportSheetRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


@Service
public class ImportSheetServiceImpl extends AbstractCrudService<ImportSheetEntity, ImportSheetOperationRequest> implements ImportSheetService<ImportSheetEntity, ImportSheetOperationRequest> {

    private final ImportSheetRepository importSheetRepository;

    public ImportSheetServiceImpl(ImportSheetRepository jpaRepository) {
        super(jpaRepository);
        this.importSheetRepository = jpaRepository;
    }

    @Override
    public ImportSheetEntity create(ImportSheetOperationRequest request) {

        ImportSheetEntity sheet= request.toImportSheet();
        this.jpaRepository.save(sheet);
        return sheet;
    }

    @Override
    public ImportSheetEntity update(ImportSheetOperationRequest request) {
        return null;
    }
}
