package com.isaac.pethospital.medicine.services;

import com.isaac.pethospital.common.converter.HanyuPinyinConverter;
import com.isaac.pethospital.common.services.AbstractCrudService;
import com.isaac.pethospital.medicine.dtos.ExportSheetOperationRequest;
import com.isaac.pethospital.medicine.entities.ExportItemEntity;
import com.isaac.pethospital.medicine.entities.ExportSheetEntity;
import com.isaac.pethospital.medicine.entities.InventoryItemEntity;
import com.isaac.pethospital.medicine.repository.ExportSheetRepository;
import com.isaac.pethospital.medicine.repository.InventoryItemRepository;
import org.springframework.stereotype.Service;


@Service
public class ExportSheetServiceImpl extends AbstractCrudService<ExportSheetEntity, ExportSheetOperationRequest> implements ExportSheetService<ExportSheetEntity, ExportSheetOperationRequest> {

    private final ExportSheetRepository exportSheetRepository;
    private final InventoryItemRepository inventoryItemRepository;

    private final HanyuPinyinConverter converter;

    public ExportSheetServiceImpl(ExportSheetRepository jpaRepository, InventoryItemRepository inventoryItemRepository, HanyuPinyinConverter converter) {
        super(jpaRepository);
        this.exportSheetRepository = jpaRepository;
        this.inventoryItemRepository = inventoryItemRepository;
        this.converter = converter;
    }

    @Override
    public ExportSheetEntity create(ExportSheetOperationRequest request) {

        ExportSheetEntity sheet = request.toExportSheet(converter);
        this.jpaRepository.save(sheet);

        for (ExportItemEntity item : sheet.getExportItemList()) {
            Long id = item.getInventoryItemId();
            if (id == null)
                throw new RuntimeException("Cannot Inventory Id is null ");
            InventoryItemEntity iie = this.inventoryItemRepository.findOne(id);
            if (iie == null)
                throw new RuntimeException("Cannot Find InventoryItemEntity by given id:" + id);

            iie.setAmount(iie.getAmount().subtract(item.getAmount()));
            this.inventoryItemRepository.save(iie);
        }

        return sheet;
    }

    @Override
    public ExportSheetEntity update(ExportSheetOperationRequest request) {
        return null;
    }
}
