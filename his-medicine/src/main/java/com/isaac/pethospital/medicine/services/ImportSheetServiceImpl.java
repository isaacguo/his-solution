package com.isaac.pethospital.medicine.services;

import com.isaac.pethospital.common.converter.HanyuPinyinConverter;
import com.isaac.pethospital.common.services.AbstractCrudService;
import com.isaac.pethospital.medicine.dtos.ImportSheetOperationRequest;
import com.isaac.pethospital.medicine.entities.ImportItemEntity;
import com.isaac.pethospital.medicine.entities.ImportSheetEntity;
import com.isaac.pethospital.medicine.entities.InventoryItemEntity;
import com.isaac.pethospital.medicine.repository.ImportSheetRepository;
import com.isaac.pethospital.medicine.repository.InventoryItemRepository;
import org.springframework.stereotype.Service;


@Service
public class ImportSheetServiceImpl extends AbstractCrudService<ImportSheetEntity, ImportSheetOperationRequest> implements ImportSheetService<ImportSheetEntity, ImportSheetOperationRequest> {

    private final ImportSheetRepository importSheetRepository;
    private final InventoryItemRepository inventoryItemRepository;

    private final HanyuPinyinConverter converter;

    public ImportSheetServiceImpl(ImportSheetRepository jpaRepository, InventoryItemRepository inventoryItemRepository, HanyuPinyinConverter converter) {
        super(jpaRepository);
        this.importSheetRepository = jpaRepository;
        this.inventoryItemRepository=inventoryItemRepository;
        this.converter=converter;
    }

    @Override
    public ImportSheetEntity create(ImportSheetOperationRequest request) {

        ImportSheetEntity sheet= request.toImportSheet(converter);
        this.jpaRepository.save(sheet);

        for(ImportItemEntity item: sheet.getImportItemList())
        {
            Long id= item.getInventoryItemId();
            if(id==null)
                throw new RuntimeException("Cannot Inventory Id is null ");
            InventoryItemEntity iie= this.inventoryItemRepository.findOne(id);
            if(iie==null)
                throw new RuntimeException("Cannot Find InventoryItemEntity by given id:"+id);

            iie.setAmount(iie.getAmount().add(item.getAmount()));
            this.inventoryItemRepository.save(iie);
        }

        return sheet;
    }

    @Override
    public ImportSheetEntity update(ImportSheetOperationRequest request) {
        return null;
    }
}
