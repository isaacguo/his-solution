package com.isaac.pethospital.medicine.restcontrollers;


import com.isaac.pethospital.common.restcontrollers.AbstractCRUDRestController;
import com.isaac.pethospital.common.services.CrudService;
import com.isaac.pethospital.medicine.dtos.ImportSheetOperationRequest;
import com.isaac.pethospital.medicine.dtos.InventoryItemOperationRequest;
import com.isaac.pethospital.medicine.entities.ImportSheetEntity;
import com.isaac.pethospital.medicine.entities.InventoryItemEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("inventory-items")
public class InventoryItemRestController extends AbstractCRUDRestController<InventoryItemEntity, InventoryItemOperationRequest> {

    public InventoryItemRestController(CrudService<InventoryItemEntity, InventoryItemOperationRequest> crudService) {
        super(crudService);
    }

}
