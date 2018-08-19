package com.isaac.pethospital.medicine.restcontrollers;

import com.isaac.pethospital.common.restcontrollers.AbstractCRUDRestController;
import com.isaac.pethospital.common.services.CrudService;
import com.isaac.pethospital.medicine.dtos.InventoryCategoryOperationRequest;
import com.isaac.pethospital.medicine.entities.InventoryCategoryEntity;
import com.isaac.pethospital.medicine.services.InventoryCategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("inventory-categories")
public class InventoryCategoryRestController extends AbstractCRUDRestController<InventoryCategoryEntity, InventoryCategoryOperationRequest> {

    private final InventoryCategoryService inventoryCategoryService;

    public InventoryCategoryRestController(InventoryCategoryService inventoryCategoryService) {
        super(inventoryCategoryService);
        this.inventoryCategoryService=inventoryCategoryService;
    }

    @GetMapping("roots")
    public List<InventoryCategoryEntity> findRoots()
    {
        return this.inventoryCategoryService.findRoots();
    }


}
